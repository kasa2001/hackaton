package com.hackaton.model;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {

    private FileReader(){}

    /**
     * Read data from file and write to base
     *
     * @param fileName name of file to read
     */
    public static void fileToDatabase(String fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            DataInputStream dataInputStream = new DataInputStream(file);
            BufferedInputStream in = new BufferedInputStream(dataInputStream);


            if(in.read() == 0xFF && in.read() > 0x0F){
                Frame f = getHeader(in);
            }


            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Frame getHeader(BufferedInputStream in){
        Frame f = new Frame();





        return f;
    }
}
