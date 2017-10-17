package com.hackaton.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class MainWindow extends JFrame {

    private Main main;
    private File file;
    private JLabel label;

    MainWindow(Main main) {
        this.main = main;
        JPanel contentPane = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JPanel mid = new JPanel();
        label = new JLabel("Nie wybrano pliku");
        JButton button = new JButton("Wybierz plik");
        JButton analize = new JButton("Analizuj");
        JProgressBar progressBar = new JProgressBar();

        contentPane.setLayout(new BorderLayout());
        top.setLayout(new FlowLayout());
        bottom.setLayout(new FlowLayout());
        top.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        mid.setBorder(BorderFactory.createEmptyBorder(10,0,0,10));
        bottom.setBorder(BorderFactory.createEmptyBorder(10, 150, 10, 150));


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

        progressBar.setValue(50);

        top.add(label);
        mid.add(progressBar);
        bottom.add(button);
        bottom.add(analize);


        contentPane.add(top, BorderLayout.NORTH);
        contentPane.add(mid, BorderLayout.CENTER);
        contentPane.add(bottom, BorderLayout.SOUTH);

        analize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAnalyze();
            }
        });

        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public File getFile() {
        return file;
    }

    private void onAnalyze(){
        main.showResult();
    }
}
