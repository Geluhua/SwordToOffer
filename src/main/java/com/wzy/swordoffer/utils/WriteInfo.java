package com.wzy.swordoffer.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wzy on 16-3-10.
 */
public class WriteInfo {
    public static void main(String args[]) {
        File file = new File("./array.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            for (int i = 0; i < 100; i ++) {
                String content = String.valueOf(i);
                if (i < 10) {
                    content = "0" + content;
                }
                writer.write("<item>" + content + "</item>" + "\n");
                writer.flush();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
