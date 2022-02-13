package edu.exercises.launcher;

import java.io.Reader;
import java.io.StringReader;
import java.util.Scanner;

import edu.exercises.model.LexicalAnalizer;

public class Main {
    public static void main(String[] args) {
        String in = "";
        Scanner scan = new Scanner(System.in);

        while (!(in = scan.nextLine()).equals("END")) {
            Reader reader = new StringReader(in);
            LexicalAnalizer lex = new LexicalAnalizer(reader);

            readTokens(lex);
            printResults(lex);
        }

        scan.close();
    }

    private static void readTokens(LexicalAnalizer lex) {
        try {
            while (lex.yylex() != LexicalAnalizer.YYEOF) {
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printResults(LexicalAnalizer lex) {
        System.out.println("One vocal: " + lex.getOneVocal());
        System.out.println("Two vocal: " + lex.getTwoVocal());
        System.out.println("Three vocal: " + lex.getThreeVocal());
        System.out.println("Four vocal: " + lex.getFourVocal());
        System.out.println("Five vocal: " + lex.getFiveVocal());
        System.out.println("More vocal: " + lex.getSoMuchVocal());
    }
}