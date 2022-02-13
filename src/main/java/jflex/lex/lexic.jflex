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
  private int oneVowel = 0;
  private int twoVowel = 0;
  private int threeVowel = 0;
  private int fourVowel = 0;
  private int fiveVowel = 0;
  private int soMuchVowels = 0;
  private int numOfVowels = 0;

  private List<IntegerToken> ints = new ArrayList<>();

  private void addNumOfVowels() {
    this.numOfVowels++;
  }

  private void addIntegers(int line, int col, String lexem) {
    ints.add(new IntegerToken(line, col, Integer.parseInt(lexem)));
  }

  private void addWordToCounters() {
    switch (this.numOfVowels) {
      case 0:
        /* do nothing */
        break;
      case 1:
        this.oneVowel++;
        break;
      case 2:
        this.twoVowel++;
        break;
      case 3:
        this.threeVowel++;
        break;
      case 4:
        this.fourVowel++;
        break;
      case 5:
        this.fiveVowel++;
        break;
      default:
        this.soMuchVowels++;
    }

    this.numOfVowels = 0;
  }

  public IntegerToken[] getIntegers() {
    return this.ints.toArray(new IntegerToken[0]);
  }

  public int getOneVowel() {
    return this.oneVowel;
  }

  public int getTwoVowel() {
    return this.twoVowel;
  }

  public int getThreeVowel() {
    return this.threeVowel;
  }

  public int getFourVowel() {
    return this.fourVowel;
  }

  public int getFiveVowel() {
    return this.fiveVowel;
  }

  public int getSoMuchVowel() {
    return this.soMuchVowels;
  }

%}

%eof{
  if (this.numOfVowels != 0)
    addWordToCounters();
%eof}

%%

[ \n\t\r]+    { addWordToCounters(); }
[0-9]+        { addIntegers(yyline, yycolumn, yytext()); }
[aeiouAEIOU]  { addNumOfVowels(); }
[^]           { /* Without action. */ }