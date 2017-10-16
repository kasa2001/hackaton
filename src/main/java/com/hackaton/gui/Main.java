package com.hackaton.gui;

import java.awt.*;

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

    void showResult(){
        result.setModel();
        result.setVisible(true);
        mainWindow.setVisible(false);
    }

    void showMain(){
        mainWindow.setVisible(true);
        result.setVisible(false);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Main());
    }
}
