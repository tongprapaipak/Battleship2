package battleship;

class GridPosition {

  //Attributes
  private int Row;
  private int Column;

  //Constructor
  public GridPosition(int r, int c) {
    this.Row = r;
    this.Column = c;
  }

  public int getRow() {
    return this.Row;
  }

  public int getColumn() {
    return this.Column;
  }

  public String getPosAsString() {
    return "R: " + this.Row + ", C: " + this.Column ;
  }



}
