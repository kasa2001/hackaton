package com.hackaton.gui;

import java.awt.*;


public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                MainWindow main = new MainWindow();
//                main.setVisible(true);
                ResultWindow result = new ResultWindow();
                result.setVisible(true);
            }
        });
    }
}
