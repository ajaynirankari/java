package com.gl.JavaTrainingSession14;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Sample {
    public static void main(String[] args) throws Exception {

        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("data.txt"));
        //Scanner scanner = new Scanner(new File("C:\\data\\NewData.txt"));

        String nextLine = scanner.nextLine();
        System.out.println("nextLine1 = " + nextLine);

        nextLine = scanner.nextLine();
        System.out.println("nextLine1 = " + nextLine);

        nextLine = scanner.nextLine();
        System.out.println("nextLine1 = " + nextLine);


        boolean isAnyData = scanner.hasNext();
        System.out.println("isAnyData = " + isAnyData);
        while (isAnyData == true) {
            String line = scanner.nextLine();
            System.out.println("line = " + line);
            isAnyData = scanner.hasNext();
            System.out.println("isAnyData = " + isAnyData);
        }

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        String fileHeaderLine = scanner.nextLine();
        System.out.println("fileHeaderLine = " + fileHeaderLine);
        int[] plotterData = new int[31];

        while (scanner.hasNextInt()) {
            String line = scanner.nextLine();
            System.out.println("line = " + line);

            String[] split = line.split(",");
            int t = Integer.parseInt(split[0]);
            int s = Integer.parseInt(split[1]);
            System.out.println("t=" + t + ",s=" + s);
            if (t < plotterData.length)
                plotterData[t] = s;

            Scanner scanner1 = new Scanner(line);
            scanner1.useDelimiter(",");
            System.out.println("line = " + line);
            t = scanner1.nextInt();
            s = scanner1.nextInt();
            System.out.println("t=" + t + ",s=" + s);

            if (t < plotterData.length)
                plotterData[t] = s;
        }
        System.out.println("Arrays.toString(plotterData) = " + Arrays.toString(plotterData));

        String str = "40,5,2,8,9,Hello";
        String[] split = str.split(",");
        String s1 = split[0];
        String s2 = split[1];
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        while (scanner.hasNext()) {
            String s_ = scanner.nextLine();
            String[] split_ = s_.split(",");

            if (split_.length == 2 && split_[0].equals("10")) {
                System.out.println("split_[0] = " + split_[0]);
                System.out.println("split_[1] = " + split_[1]);
            }
            System.out.println(Arrays.toString(split));
        }
        System.out.println("Done");
    }
}
