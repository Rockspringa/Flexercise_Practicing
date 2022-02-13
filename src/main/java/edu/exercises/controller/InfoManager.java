package edu.exercises.controller;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import edu.exercises.model.IntegerToken;
import edu.exercises.model.LexicalAnalizer;

public class InfoManager {

    private JList<Object> list;

    public InfoManager(JList<Object> list) {
        this.list = list;
    }

    public void fillList(String textToAnalize) {
        Reader reader = new StringReader(textToAnalize);
        LexicalAnalizer lex = new LexicalAnalizer(reader);

        readTokens(lex);
        setResultsToList(lex);
    }

    private void readTokens(LexicalAnalizer lex) {
        try {
            while (lex.yylex() != LexicalAnalizer.YYEOF) {
                /* No catching anything more, just cycling */
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Error during analysis", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setResultsToList(LexicalAnalizer lex) {
        DefaultListModel<Object> model = new DefaultListModel<>();

        String[] ins = { "una", "dos", "tres", "cuatro", "cinco", "mas" };
        int[] data = { lex.getOneVocal(), lex.getTwoVocal(), lex.getThreeVocal(),
                lex.getFourVocal(), lex.getFiveVocal(), lex.getSoMuchVocal() };

        for (int i = 0; i < ins.length; i++) {
            if (data[i] != 0) {
                if (ins[i].equals("una")) {
                    model.addElement("Palabras de " + ins[i] + " vocal: " + data[i]);
                } else {
                    model.addElement("Palabras de " + ins[i] + " vocales: " + data[i]);
                }
            }
        }

        for (IntegerToken token : lex.getIntegers()) {
            model.addElement(token);
        }

        list.setModel(model);
    }

}
