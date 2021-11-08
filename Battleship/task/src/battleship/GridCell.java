package battleship;

public class GridCell {

  //Rolls

  private GridPosition position;
  private GridCell nextHorizontalCell;
  private GridCell nextVerticalCell;
  private GridCell prevHorizontalCell;
  private GridCell prevVerticalCell;
  private String status; // "O", "X", "M" or "~"
  private String shipType; // ac bt su cr ds

  //Constructor
  public GridCell (final int R, final int C) {
    this.position = new GridPosition(R, C);
    //this.shipType = shipType;
  }




  //operations
  /*
  public void associatedConnectedCells(final int R, final int C) {

    if (C > 1) {
      GridCell prevHorzCell = PlayingGrid.getGridCell(R, C - 1);
      prevHorzCell.nextHorizontalCell = this;
      this.prevHorizontalCell = prevHorzCell;
    }

    if (R > 1) {
      GridCell prevVertCell = PlayingGrid.getGridCell(R - 1, C);
      prevVertCell.nextVerticalCell = this;
      this.prevVerticalCell = prevVertCell;
    }
  }*/

  //methods
  public void setStatus(String status) {

    this.status = status;
    //this.shipType = shipType;
  }

  public String getStatus() {
    return this.status;
  }

  public void setShipType(String shipType) {
    this.shipType = shipType;
  }
  public String getShipType() { return this.shipType; }

  public GridPosition getPosition() {
    return this.position;
  }

  public GridCell getNextHorizontalCell() {
    return this.nextHorizontalCell;
  }

  public void setNextHorizontalCell(final GridCell Cell) {
    this.nextHorizontalCell = Cell;
  }

  public GridCell getPrevHorizontalCell() {
    return this.prevHorizontalCell;
  }

  public void setPrevHorizontalCell(final GridCell Cell) {
    this.prevHorizontalCell = Cell;
  }

  public GridCell getNextVerticalCell() {
    return this.nextVerticalCell;
  }

  public void setNextVerticalCell(final GridCell Cell) {
    this.nextVerticalCell = Cell;
  }

  public GridCell getPrevVerticalCell() {
    return this.prevVerticalCell;
  }

  public void setPrevVerticalCell(final GridCell Cell) {
    this.prevVerticalCell = Cell;
  }


}
