package battleship;

public class PlayingGrid {

  public static int gridSize = 11;


  private GridCell[][] theGrid;
  private String status; // "O", "X", "M" or "~"
  private int PlayerNumber;
  private GridCell gridCell;
  private String shipType;

  //Roles
  //public static PlayingGrid Instance; old singleton design
  public PlayingGrid(final int PlayerNumber) {
    this.theGrid = new GridCell[gridSize][gridSize];
    this.PlayerNumber = PlayerNumber;

    for (int r = 1; r < gridSize; r++) {
      for (int c = 1; c < gridSize; c++) {
        this.theGrid[r][c] = new GridCell(r, c);
        this.theGrid[r][c].setStatus("~");
      }
    }

    char letter = 'A';
    for (int r = 1; r < gridSize; r++) {
      this.theGrid[r][0] = new GridCell(r, 0);
      this.theGrid[r][0].setStatus(String.valueOf(letter));
      letter++;
    }


  }
  

  /* old singleton design pattern
  public static PlayingGrid getInstance() {
    String shipType = null;
    if (Instance == null) {
      Instance = new PlayingGrid();
      System.out.println("created new instance of Playing Grid");
      Instance.theGrid = new GridCell[gridSize][gridSize];
      System.out.println("created new instance Grid Cell");

      for (int r = 1; r < gridSize; r++) {
        for (int c = 1; c < gridSize; c++) {
          Instance.theGrid[r][c] = new GridCell(r, c, shipType);
          Instance.theGrid[r][c].setStatus("~", shipType);
        }
      }
      char letter = 'A';
      for (int r = 1; r < gridSize; r++) {
        Instance.theGrid[r][0] = new GridCell(r, 0, shipType);
        Instance.theGrid[r][0].setStatus(String.valueOf(letter), shipType);
        letter++;
      }
    }
    return Instance;
  } */

  public void printGameBoard() {
    System.out.print("  ");
    for (int row = 1; row <= 10; row++ ) {
      System.out.print(row + " ");
    }
    System.out.println();

    for (int r = 1; r <= 10; r++) {
      for (int c = 0; c <= 10; c++) {
        System.out.print(this.theGrid[r][c].getStatus() + " ");
      }
      System.out.println();
    }
  }

  public void printHiddenGameBoard() {

    System.out.print("  ");
    for (int row = 1; row <= 10; row++ ) {
      System.out.print(row + " ");
    }
    System.out.println();

    for (int r = 1; r <= 10; r++) {
      for (int c = 0; c <= 10; c++) {
        if ("O".equals(this.theGrid[r][c].getStatus())) {
          System.out.print("~" + " ");
        } else {
          System.out.print(this.theGrid[r][c].getStatus() + " ");
        }
      }
      System.out.println();
    }

  }


  public void associateCell() {
    for (int r = 1; r < gridSize; r++) {
      for (int c = 1; c < gridSize; c++) {
        GridCell thisCell = this.theGrid[r][c];
        //thisCell.associatedConnectedCells(r, c);


          if (c > 0) {
            GridCell prevHorzCell = this.theGrid[r][c];
            prevHorzCell.setNextHorizontalCell(thisCell);
            thisCell.setPrevHorizontalCell(thisCell);
          }

          if (r > 0) {
            GridCell prevVertCell = this.theGrid[r][c];
            prevVertCell.setPrevVerticalCell(thisCell);
            thisCell.setPrevVerticalCell(thisCell);
          }

      }
    }
  }





  public GridCell getGridCell(final int R, final int C) {
    return this.theGrid[R][C];
  }

  public String getShipType (final int R, final int C) {
    return shipType;
  }

  private PlayingGrid getPlayingGrid() {
    return this;
  }


  public void setGridCellStatus(final int R, final int C, String status, String shipType) {
    this.theGrid[R][C].setStatus(status);
    //System.out.println("Playing Grid method setGridCellStatus Setting Ship Type: " + shipType);
    this.theGrid[R][C].setShipType(shipType);
  }

  public int getPlayerNumber() {
    return this.PlayerNumber;
  }




}
