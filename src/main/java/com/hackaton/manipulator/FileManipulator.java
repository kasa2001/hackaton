package com.hackaton.manipulator;

import com.hackaton.model.KeywordsObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManipulator {

    private static FileManipulator fm;
    private String path;
    private String keypath = "data/keywords_POL.txt";
    private List<KeywordsObject> keywords = new ArrayList<>();

    private FileManipulator() {}


    /**
     * Setting file path to read
     * @param path String path to file
     * */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Get file path to read
     * */
    public String getPath() {
        return this.path;
    }

    /**
     * Method prepare keywords
     * */
    public void prepareKeywords() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(keypath));
            String item;
            while ((item = br.readLine()) != null) {
                this.keywords.add(new KeywordsObject(item.toLowerCase(),0));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Method get sizeof list
     * */
    public int getSize() {
        return this.keywords.size();
    }

    /**
     * Method reading file
     * @throws IOException if file not opened
     * */
    public int readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.path));
        int i=0;

        String item;

        while ((item = br.readLine()) != null) {
            this.checkString(item);
            i++;
        }

        return i;
    }

    /**
     * Method for creating (in not exists) and returning FileManipulator object
     * @return FileManipulator
     * */
    public static synchronized FileManipulator getInstance() {
        if (FileManipulator.fm == null) {
            FileManipulator.fm = new FileManipulator();
        }

        return FileManipulator.fm;
    }

    private void checkString(String item) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < item.length(); i++) {

            if (item.charAt(i) == ' ' || !Character.isLetter(item.charAt(i))) {

                i = this.skip(i, item);

                this.add(sb);
                sb = new StringBuilder();

            } else {

                sb.append(Character.toLowerCase(item.charAt(i)));

            }
        }

        this.add(sb);
    }

    private int skip(int i, String item) {
        for (; i < item.length();i++) {
            if (item.charAt(i) == ' ')
                break;
        }

        return i;
    }

    private void add(StringBuilder sb) {
        for (KeywordsObject ko: this.keywords) {
            if (ko.getName().equals(sb.toString())) {
                ko.increment();
                break;
            }
        }
    }
}
