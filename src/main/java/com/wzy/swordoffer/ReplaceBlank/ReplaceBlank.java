package com.wzy.swordoffer.ReplaceBlank;

import java.io.IOException;
import java.util.Scanner;

/**
 * 题目:请实现一个函数，把字符串中的每个空格替换成"%20"
 * 九度OJ链接：http://ac.jobdu.com/problem.php?pid=1510
 */
public class ReplaceBlank {
    private static String replaceBlank(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        char[] srcInputs = input.toCharArray();
        int numBlanks = 0;
        for (char ch : srcInputs) {
            if (ch == ' ') {
                numBlanks ++;
            }
        }

        char[] destOutputs = new char[srcInputs.length + 2 * numBlanks];
        int i = srcInputs.length - 1, j = destOutputs.length - 1;
        while (i >= 0) {
            if (srcInputs[i] != ' ') {
                destOutputs[j --] = srcInputs[i];
            } else {
                destOutputs[j --] = '0';
                destOutputs[j --] = '2';
                destOutputs[j --] = '%';
            }
            i --;
        }

        return new String(destOutputs);
    }

    private static String replaceBlank1(String input) {
        return input.replaceAll(" ", "%20");
    }

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String inputStr = scanner.nextLine();
            System.out.println(replaceBlank1(inputStr));
            System.out.println(replaceBlank(inputStr));
        }

        scanner.close();
    }
}
