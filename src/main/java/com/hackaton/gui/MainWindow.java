package com.hackaton.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class MainWindow extends JFrame {

    private File file;
    private JLabel label;

    MainWindow() {
        JPanel contentPane = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        label = new JLabel("Nie wybrano pliku");
        JButton button = new JButton("Wybierz plik");

        contentPane.setLayout(new BorderLayout());
        top.setLayout(new FlowLayout());
        bottom.setLayout(new FlowLayout());
        top.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        bottom.setBorder(BorderFactory.createEmptyBorder(20, 150, 10, 150));


        button.addActionListener(new ActionListener() {
            /**
             * Choosing file after click
             * */
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int val = fc.showOpenDialog(contentPane);

                if (val == JFileChooser.APPROVE_OPTION) {
                    file = fc.getSelectedFile();
                    label.setText(file.getName());
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

        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
