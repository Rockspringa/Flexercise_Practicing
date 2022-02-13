package edu.exercises.model;

import java.util.List;
import java.util.ArrayList;

%%

%class LexicalAnalizer
%unicode
%column
%line
%public
%int

%{
  private int oneVocal = 0;
  private int twoVocal = 0;
  private int threeVocal = 0;
  private int fourVocal = 0;
  private int fiveVocal = 0;
  private int soMuchVocals = 0;
  private int numOfVocals = 0;

  private List<IntegerToken> ints = new ArrayList<>();

  private void addNumOfVocals() {
    this.numOfVocals++;
  }

  private void addIntegers(int line, int col, String lexem) {
    ints.add(new IntegerToken(line, col, Integer.parseInt(lexem)));
  }

  private void addWordToCounters() {
    switch (this.numOfVocals) {
      case 0:
        /* do nothing */
        break;
      case 1:
        this.oneVocal++;
        break;
      case 2:
        this.twoVocal++;
        break;
      case 3:
        this.threeVocal++;
        break;
      case 4:
        this.fourVocal++;
        break;
      case 5:
        this.fiveVocal++;
        break;
      default:
        this.soMuchVocals++;
    }

    this.numOfVocals = 0;
  }

  public IntegerToken[] getIntegers() {
    return this.ints.toArray(new IntegerToken[0]);
  }

  public int getOneVocal() {
    return this.oneVocal;
  }

  public int getTwoVocal() {
    return this.twoVocal;
  }

  public int getThreeVocal() {
    return this.threeVocal;
  }

  public int getFourVocal() {
    return this.fourVocal;
  }

  public int getFiveVocal() {
    return this.fiveVocal;
  }

  public int getSoMuchVocal() {
    return this.soMuchVocals;
  }

%}

%eof{
  if (this.numOfVocals != 0)
    addWordToCounters();
%eof}

%%

[ ]+        { addWordToCounters(); }
[0-9]+       { addIntegers(yyline, yycolumn, yytext()); }
[aeiou]     { addNumOfVocals(); }
[^]         { /* Without action. */ }