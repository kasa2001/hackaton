package com.hackaton.gui;

import com.hackaton.model.ResultsModel;

import javax.swing.*;
import java.awt.*;

class ResultWindow extends JFrame {

    /**
     * Data model for table
     * */
    private ResultsModel model;


    ResultWindow() {
        JPanel contentPane = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JLabel label1 = new JLabel();

        label1.setText("label1");

        contentPane.setLayout(new BorderLayout());
        top.setLayout(new FlowLayout());
        bottom.setLayout(new FlowLayout());


        setModel(); //TODO usunąć i użyć z parametrem gdzie indziej


        JTable table = new JTable(model);
        table.setShowGrid(true);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        bottom.add(scrollPane);
        top.add(label1);
        contentPane.add(top, BorderLayout.NORTH);
        contentPane.add(bottom, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

    public void setModel() {
        this.model = new ResultsModel();
    }

    public void setModel(ResultsModel model) {
        this.model = model;
    }
}
