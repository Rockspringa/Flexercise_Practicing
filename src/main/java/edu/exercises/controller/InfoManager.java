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
                    "Error during analisis", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setResultsToList(LexicalAnalizer lex) {
        DefaultListModel<Object> model = new DefaultListModel<>();

        model.addElement("Palabras de una vocal: " + lex.getOneVocal());
        model.addElement("Palabras de dos vocales: " + lex.getTwoVocal());
        model.addElement("Palabras de tres vocales: " + lex.getThreeVocal());
        model.addElement("Palabras de cuatro vocales: " + lex.getFourVocal());
        model.addElement("Palabras de cinco vocales: " + lex.getFiveVocal());
        model.addElement("Palabras de mas vocales: " + lex.getSoMuchVocal());

        for (IntegerToken token : lex.getIntegers()) {
            model.addElement(token);
        }

        list.setModel(model);
    }

}
