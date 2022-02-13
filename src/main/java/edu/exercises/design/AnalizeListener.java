package edu.exercises.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;

import edu.exercises.controller.InfoManager;

public class AnalizeListener implements ActionListener {

    private InfoManager infoManager;
    private JTextPane textPane;

    public AnalizeListener(InfoManager infoManager, JTextPane textPane) {
        this.infoManager = infoManager;
        this.textPane = textPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        infoManager.fillList(textPane.getText());
    }
    
}
