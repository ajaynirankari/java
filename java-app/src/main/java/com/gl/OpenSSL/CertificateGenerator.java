package com.gl.OpenSSL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class CertificateGenerator {
    public static final String CA_PRIVATE_KEY = "ca-private-key.pem";
    public static final String CA_CERTIFICATE = "ca-certificate.pem";
    public static final String CERTIFICATE = "certificate.pem";
    private static final String CLIENT_CSR = "client-csr.pem";
    public static final String CA_CERT_PASS_PHRASE = "passphrase123";
    private static final String OPENSSL = "openssl ";
    private static final String SUBJ = " -subj /C=%s/ST=%s/L=%s/O=%s/OU=%s/emailAddress=%s/CN=%s";
    private static final String GENERATE_PRIVATE_KEY = STR."\{OPENSSL}genpkey -algorithm RSA -out \{CA_PRIVATE_KEY} -aes256 -pass pass:%s";
    private static final String CREATE_CA_CERTIFICATE = STR."\{OPENSSL}req -x509 -new -key \{CA_PRIVATE_KEY} -out \{CA_CERTIFICATE} -days %s -passin pass:%s\{SUBJ}";
    private static final String GENERATE_CLIENT_CSR = STR."\{OPENSSL}req -new -key \{CA_PRIVATE_KEY} -out \{CLIENT_CSR} -passin pass:%s\{SUBJ}";
    private static final String SIGN_CLIENT_CERTIFICATE_WITH_CA = STR."\{OPENSSL}x509 -req -in \{CLIENT_CSR} -CA \{CA_CERTIFICATE} -CAkey \{CA_PRIVATE_KEY} -CAcreateserial -out \{CERTIFICATE} -days %s -passin pass:%s";

    /**
     * The following steps are used to generate the certificates via openssl command
     * Step 1: Generate Private Key
     * Step 2: Create a Certificate Authority (CA) Certificate
     * Step 3: Generate Certificate Signing Request (CSR) for the Client
     * Step 4: Sign the Client Certificate with the CA*
     */
    public Map<String, String> generateCertificates(int validityDays, String countryName, String state, String locality, String orgName, String orgUnit, String email) throws Exception {

        // Step 1: Generate Private Key
        executeCommand(String.format(GENERATE_PRIVATE_KEY, CA_CERT_PASS_PHRASE));

        // Step 2: Create a Certificate Authority (CA) Certificate
        executeCommand(String.format(CREATE_CA_CERTIFICATE, validityDays, CA_CERT_PASS_PHRASE, countryName, state, locality, orgName, orgUnit, email, "CaCert"));

        // Step 3: Generate Certificate Signing Request (CSR) for the Client
        executeCommand(String.format(GENERATE_CLIENT_CSR, CA_CERT_PASS_PHRASE, countryName, state, locality, orgName, orgUnit, email, "ClientCert"));

        // Step 4: Sign the Client Certificate with the CA
        executeCommand(String.format(SIGN_CLIENT_CERTIFICATE_WITH_CA, validityDays, CA_CERT_PASS_PHRASE));

        Map<String, String> certificates = putCertificationFilesAsStringInMap();

        deleteCertificateFiles();

        return certificates;
    }

    private void deleteCertificateFiles() throws IOException {
        Files.deleteIfExists(Path.of(CA_PRIVATE_KEY));
        Files.deleteIfExists(Path.of(CLIENT_CSR));
        Files.deleteIfExists(Path.of(CA_CERTIFICATE));
        Files.deleteIfExists(Path.of(CERTIFICATE));
        Files.deleteIfExists(Path.of("ca-certificate.srl"));
    }

    private Map<String, String> putCertificationFilesAsStringInMap() throws Exception {
        Map<String, String> certificates = new ConcurrentHashMap<>();
        certificates.put(CA_PRIVATE_KEY, readCertificateFileToString(CA_PRIVATE_KEY));
        certificates.put(CA_CERTIFICATE, readCertificateFileToString(CA_CERTIFICATE));
        certificates.put(CERTIFICATE, readCertificateFileToString(CERTIFICATE));
        return certificates;
    }

    private String readCertificateFileToString(String filePath) throws Exception {
        StringBuilder contentBuilder = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(filePath)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    contentBuilder.append(line);
                    contentBuilder.append(System.lineSeparator());
                }
            }
        }
        return contentBuilder.toString();
    }

    private void executeCommand(String command) throws Exception {
        System.out.println(STR."executeCommand =  \{command}");
        Process process = Runtime.getRuntime().exec(command);
        int exitVal = process.waitFor();
        if (exitVal != 0) {
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            StringBuilder error = new StringBuilder();
            String errorLine;
            while ((errorLine = stdError.readLine()) != null) {
                error.append(errorLine);
            }
            throw new Exception(STR."Failed to execute \nCommand: \{command} \nError: \{error}");
        }
    }

    public static void main(String[] args) throws Exception {
        var certificateGenerator = new CertificateGenerator();

        int validityDays = 365;
        String countryName = "IN";
        String state = "Delhi";
        String locality = "NewDelhi";
        String orgName = "Global";
        String orgUnit = "IT";
        String email = "support@gmail.com";

        var certificates = certificateGenerator.generateCertificates(validityDays, countryName, state, locality, orgName, orgUnit, email);

        var caPrivateKey = certificates.get(CA_PRIVATE_KEY);
        var caCertificate = certificates.get(CA_CERTIFICATE);
        var certificate = certificates.get(CERTIFICATE);

        System.out.println(STR."caPrivateKey = \{caPrivateKey}");
        System.out.println(STR."caCertificate = \{caCertificate}");
        System.out.println(STR."certificate = \{certificate}");
    }
}
/*

First Install the openssl in your system
From https://community.chocolatey.org/packages/openssl
Run the following command in the PowerShell as an Administrator
    choco install openssl

Set the system environment variable for openssl

----------------------------------------------------------------
Step 1: Generate Private Key
openssl genpkey -algorithm RSA -out private-key.pem
Step 2: Create a Certificate Authority (CA) Certificate
openssl req -x509 -new -nodes -key private-key.pem -sha256 -days 365 -out ca-certificate.pem
Step 3: Generate Certificate Signing Request (CSR) for the Client
openssl req -new -key private-key.pem -out client-csr.pem
Step 4: Sign the Client Certificate with the CA
openssl x509 -req -in client-csr.pem -CA ca-certificate.pem -CAkey private-key.pem -CAcreateserial -out client-certificate.pem -days 365 -sha256

Optional: Verify the Client Certificate
openssl verify -CAfile ca-certificate.pem client-certificate.pem

-----------------------------------------------------------------

openssl genpkey -algorithm RSA -out ca-private-key.pem -aes256 -pass pass:passphrase123
openssl req -x509 -new -key ca-private-key.pem -out ca-certificate.pem -days 3650 -passin pass:passphrase123 -subj /C=IN/ST=Delhi/L=NewDelhi/O=Global/OU=IT/emailAddress=support@gmail.com/CN=CaCert
openssl req -new -key ca-private-key.pem -out client-csr.pem -passin pass:passphrase123 -subj /C=IN/ST=Delhi/L=NewDelhi/O=Global/OU=IT/emailAddress=support@gmail.com/CN=CaCert
openssl x509 -req -in client-csr.pem -CA ca-certificate.pem -CAkey ca-private-key.pem -out certificate.pem -days 365 -passin pass:passphrase123

openssl verify -CAfile ca-certificate.pem certificate.pem

-----------------------------------------------------------------

output:

executeCommand =  openssl genpkey -algorithm RSA -out ca-private-key.pem -aes256 -pass pass:passphrase123
executeCommand =  openssl req -x509 -new -key ca-private-key.pem -out ca-certificate.pem -days 365 -passin pass:passphrase123 -subj /C=IN/ST=Delhi/L=NewDelhi/O=Global/OU=IT/emailAddress=support@gmail.com/CN=CaCert
executeCommand =  openssl req -new -key ca-private-key.pem -out client-csr.pem -passin pass:passphrase123 -subj /C=IN/ST=Delhi/L=NewDelhi/O=Global/OU=IT/emailAddress=support@gmail.com/CN=ClientCert
executeCommand =  openssl x509 -req -in client-csr.pem -CA ca-certificate.pem -CAkey ca-private-key.pem -CAcreateserial -out certificate.pem -days 365 -passin pass:passphrase123

 */