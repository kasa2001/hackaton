package com.hackaton.gui;

import com.hackaton.model.ResultsModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ResultWindow extends JFrame {

    private Main main;
    private ResultsModel model;
    private JTable table;


    ResultWindow(Main main) {
        this.main = main;
        JPanel contentPane = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JLabel label1 = new JLabel();

        label1.setText("label1");

        contentPane.setLayout(new BorderLayout());
        top.setLayout(new FlowLayout());
        bottom.setLayout(new FlowLayout());
        bottom.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));

        table = new JTable(model);
        table.setShowGrid(true);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        bottom.add(scrollPane);
        top.add(label1);
        contentPane.add(top, BorderLayout.NORTH);
        contentPane.add(bottom, BorderLayout.SOUTH);

        setContentPane(contentPane);
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                main.showMain();
            }
        });
        pack();
    }

    public void setModel() {
        model = new ResultsModel();
        table.setModel(model);
        model.fireTableDataChanged();
    }

    public void setModel(ResultsModel model) {
        this.model = model;
    }
}
