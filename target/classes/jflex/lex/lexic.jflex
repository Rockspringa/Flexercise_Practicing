package edu.exercises.model;

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

  private void addNumOfVocals() {
    this.numOfVocals++;
  }

  private void addWordToCounters() {
    switch (this.numOfVocals) {
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
    return this.fiveVocal;
  }

%}

%eof{
  if (this.numOfVocals != 0)
    addWordToCounters();
%eof}

%%

[ ]+        { addWordToCounters(); }
[aeiou]     { addNumOfVocals(); }
[^]         { /* Without action. */ }