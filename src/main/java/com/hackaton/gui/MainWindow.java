package com.hackaton.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow {

    private MainWindow() {
        JFrame f = new JFrame("Program");
        JPanel contentPane = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();

        contentPane.setLayout(new BorderLayout());
        top.setLayout(new FlowLayout());
        bottom.setLayout(new FlowLayout());


        JLabel label = new JLabel("plik");
        JButton button = new JButton("Wybierz plik");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int val = fc.showOpenDialog(contentPane);
                if (val == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    System.out.println(file.getAbsolutePath());
                } else {
                    System.out.println("canceled");
                }
            }
        });


        top.add(label);
        bottom.add(button);

        contentPane.add(top, BorderLayout.NORTH);
        contentPane.add(bottom, BorderLayout.SOUTH);

        f.setContentPane(contentPane);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow();
            }
        });
    }
}
