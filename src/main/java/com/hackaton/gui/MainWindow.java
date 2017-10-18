package com.hackaton.gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        label = new JLabel("Nie wybrano pliku");
        JButton button = new JButton("Wybierz plik");
        JButton analize = new JButton("Analizuj");

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

                FileNameExtensionFilter filter = new FileNameExtensionFilter("pliki audio", "mp3");
                fc.setFileFilter(filter);
                fc.setAcceptAllFileFilterUsed(false);

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
        bottom.add(analize);

        contentPane.add(top, BorderLayout.NORTH);
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
