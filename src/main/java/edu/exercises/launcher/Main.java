package edu.exercises.launcher;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame panel = new JFrame();
                panel.setBounds(0, 0, 500, 500);
                panel.setVisible(true);
                panel.setLocationRelativeTo(null);
            }

        });

    }
}