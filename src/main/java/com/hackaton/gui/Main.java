package com.hackaton.gui;

import com.hackaton.finder.WordFinder;
import com.hackaton.model.DataBase;
import com.hackaton.model.ResultsModel;

import javax.xml.crypto.Data;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main implements Runnable {

    private ResultWindow result;
    private MainWindow mainWindow;

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        mainWindow = new MainWindow(this);
        result = new ResultWindow(this);
        showMain();
    }

    void showResult() {
        File file = mainWindow.getFile();

//        DataBase.getInstance();

        WordFinder wf = new WordFinder();
        wf.setPath("data/temporary.txt");
//        wf.setPath(file.getPath());
        wf.prepareKeywords();
        try {
            wf.readFile();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        result.setModel(new ResultsModel(wf.getKeywords()));

        result.setVisible(true);
        mainWindow.setVisible(false);
    }

    void showMain() {
        mainWindow.setVisible(true);
        result.setVisible(false);
    }

    public static void main(String[] args) {

//        EventQueue.invokeLater(new Main());

        String fileName = "data/rozmowa1_POL/rozmowa1a.mp3";
        DataBase db = new DataBase();
        db.fileToDatabase(fileName);
        db.close();
    }
}
