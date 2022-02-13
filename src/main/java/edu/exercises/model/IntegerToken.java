package edu.exercises.model;

public class IntegerToken {

    private final int line;
    private final int col;
    private final int lexem;

    IntegerToken(int line, int col, int lexem) {
        this.line = line;
        this.col = col;
        this.lexem = lexem;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.col;
    }

    public int getLexem() {
        return this.lexem;
    }

    @Override
    public String toString() {
        return String.format("Lexema: '%s', encontrado en la linea: %d y columna %d",
                this.lexem, this.line, this.col);
    }

}
