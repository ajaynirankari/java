package com.gl.Regex;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {
    public static void main(String[] args) {
        String REGEX = "[[^\\u0000-\\u007F]a-z0-9][(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+\\.\\-/?^_`{|}~)]{0,63}+(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[[^\\u0000-\\u007F]a-z0-9-]\\.[[^\\u0000-\\u007F]a-z0-9-]]{5,189}+";
        //String REGEX = "([\\p{L}0-9][\\p{L}0-9\\.!#\\$%\\&'\\*\\+\\-/\\?/^_`{\\|}~]{1,63}(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)(?:[\\p{L}0-9-]+\\.)+(?:[\\p{L}]{2,}(?!-)(?!\\.)(?![0-9])))";
        //String REGEX = "(?<email>[\\p{L}0-9][\\p{L}0-9\\.!#\\$%\\&'\\*\\+\\-/\\?/^_`{\\|}~]{1,63}(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)(?:[\\p{L}0-9-]+\\.)+(?:[\\p{L}]{2,}(?!-)(?!\\.)(?![0-9])))";
        //String REGEX = "(?<email>[\\p{L}0-9\\.!#\\$%\\&'\\*\\+\\-/\\?/^_`{\\|}~]{0,63}(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)(?:[\\p{L}0-9-]+\\.)+(?:[\\p{L}]{2,}(?!-)(?!\\.)(?![0-9@#])))";
        //String REGEX = "(?:(?<=(^|[\\p{Punct}\\s])))(?<email>[\\p{L}0-9\\.!#\\$%\\&'\\*\\+\\-/\\?/^_`{\\|}~]{1,63}(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)(?:[\\p{L}0-9-]+\\.)+(?:[\\p{L}]{2,}(?!-)(?!\\.)(?![0-9@#])))(?:(?=($|[\\p{Punct}\\s])))";
        //String REGEX = "[(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+-/?^_`{|}~)]{0,63}+(?<![\\.])(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[^\\u0000-\\u007F]a-z0-9-]+(?:(?:[\\.][[^\\u0000-\\u007F]a-z-]+)|(?:(?:[\\.][[^\\u0000-\\u007F]a-z0-9-]+)*(?:[\\.][[^\\u0000-\\u007F]a-z-]+))){1,}(?=($|[\\p{Punct}\\s]))";
        //String REGEX = "[[^\\u0000-\\u007F]a-z0-9][(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+-/?^_`{|}~)]{0,63}+(?<![\\.])(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[^\\u0000-\\u007F]a-z0-9-]+(?:(?:[\\.][[^\\u0000-\\u007F]a-z-]+){5,189}+|(?:[\\.][[^\\u0000-\\u007F]a-z0-9-]+)*(?:[\\.][[^\\u0000-\\u007F]a-z-]+))";
        //String REGEX = "[(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+-/?^_`{|}~)]{0,63}+(?<![\\.])(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[^\\u0000-\\u007F]a-z0-9-]+(?:(?:[\\.][[^\\u0000-\\u007F]a-z-]+)|(?:(?:[\\.][[^\\u0000-\\u007F]a-z0-9-]+)*(?:[\\.][[^\\u0000-\\u007F]a-z-]+))){1,}";
        //String REGEX = "[[^\\u0000-\\u007F]a-z0-9][(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+-/?^_`{|}~)]{0,63}+(?<![\\.])(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[^\\u0000-\\u007F]a-z0-9-]+(?:(?:[\\.][[^\\u0000-\\u007F]a-z-]+){5,189}+|(?:[\\.][[^\\u0000-\\u007F]a-z0-9-]+)*(?:[\\.][[^\\u0000-\\u007F]a-z-]+))";
        //String REGEX = "[(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+-/?^_`{|}~)]{0,63}+(?<![\\.])(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[^\\u0000-\\u007F]a-z0-9-]+(?:(?:[\\.][[^\\u0000-\\u007F]a-z-]+)|(?:(?:[\\.][[^\\u0000-\\u007F]a-z0-9-]+)*(?:[\\.][[^\\u0000-\\u007F]a-z-]+))){1,}";
        //String REGEX = "[[^\\u0000-\\u007F]a-z0-9][(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+-/?^_`{|}~)]{0,63}+(?<![\\.])(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[^\\u0000-\\u007F]a-z0-9-]+(?:(?:[\\.][[^\\u0000-\\u007F]a-z-]+){5,189}+|(?:[\\.][[^\\u0000-\\u007F]a-z0-9-]+)*(?:[\\.][[^\\u0000-\\u007F]a-z-]+))";
        //String REGEX = "[[^\\u0000-\\u007F]a-z0-9][(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+-/?^_`{|}~)]{0,63}+(?<![\\.])(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[^\\u0000-\\u007F]a-z0-9-]+(?:[\\.][[^\\u0000-\\u007F]a-z0-9-]+){1,}";
        //String REGEX = "(?<=(^|[\\p{Punct}\\s]))[[^\\u0000-\\u007F]a-z0-9][(?:[^\\u0000-\\u007F]a-z0-9!#$%&'*+-/?^_`{|}~)]{0,63}+(?<![\\.])@(?![-])(?![\\.])(?!.*?--)(?!.*?\\.\\.)(?!.*\\.$)(?!.*-$)(?=.*\\..*$)[[[^\\u0000-\\u007F]a-z0-9-]\\.[[^\\u0000-\\u007F]a-z0-9-]]{5,189}+(?=($|[\\p{Punct}\\s]))";

        Pattern pattern = Pattern.compile(beginBoundary("") + REGEX + endBoundary(""), Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        //Pattern pattern = Pattern.compile(  REGEX , Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);

        String value = null;
        value = "10.11.1.56,0.0.0.0,0.0.0.0,globalprotect-to-internal,mptest@xyz.com";
        value = "user1@gmail.co1.in";
        value = "user1@gmail.com1";
        value = "user1@gmail.com";
        value = "测试@测试.com";
        value = "d1b8a08e2f5@MEUSWAYZCorp.Cargill.com";
        value = "john983.domain.com";
        value = "john@john.com";
        value = "^john@john.com@";
        value = "@john983.domain.com@";
        value = "email@address.com.com1";
        value = "@john@john.com@";
        value = "@john983.domain.com";
        value = "john@john.com";
        value = "@john@john.com@";
        value = "john@john.com@#";
        value = "^john@john.com@";
        value = "jhon.par-ker@gm-ail.com";

        isValid(value);

        System.out.println("\tvalue = " + value);
        Matcher m = pattern.matcher(value);
        try {
            int startAt = 0;
            boolean found = m.find(startAt);
            //System.out.println("\tmatches = " + m.matches() + " found = " + found);
            for (; found; ) {
                System.out.println("\t(" + startAt + ") found = " + found);
                System.out.println("\tgroup() = " + m.group() + " group(1) = [" + m.group(1) + "] group(2) = [" + m.group(2) + "]");
                System.out.println("\tstart = " + m.start() + ", end = " + m.end());

                isValid(m.group());
                //isValid(value);
                found = m.find();
                System.out.println("\t(" + startAt++ + ") found = " + found);
                System.out.println("-----------------------------------------------------------------");
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }


    }

    static void isValid(String value) {
        boolean valid = EmailValidator.getInstance().isValid(value);
        System.out.println("\tApache API isValid = [" + valid + "] email <- " + value);
    }

    public static String beginBoundary(String excluding) {
        return "(?<=(^|" + charClass("\\p{Punct}\\s", excluding) + "))";
    }

    public static String endBoundary(String excluding) {
        return "(?=($|" + charClass("\\p{Punct}\\s", excluding) + "))";
    }

    public static String charClass(String include, String exclude) {
        if (isEmpty(exclude)) {
            return "[" + include + "]";
        } else {
            return "[" + include + "&&[^" + exclude + "]]";
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}

