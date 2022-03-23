package com.dmy.codedesign.Stream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * @Author: dongmengyang
 */
public class testStream {

    private static final ArrayList<String> lines = new ArrayList<String>();

    public static void main(String[] args) {
        ByteArrayOutputStream os =new ByteArrayOutputStream();
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(os);
            out.writeObject(lines);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
    }


}
