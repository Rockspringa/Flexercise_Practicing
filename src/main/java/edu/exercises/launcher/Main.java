package edu.exercises.launcher;

import javax.swing.SwingUtilities;

import edu.exercises.design.EntryPoint;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                EntryPoint panel = new EntryPoint();
                panel.launch();
            }

        });

    }
}