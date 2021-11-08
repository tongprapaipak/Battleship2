package battleship;
import java.util.Scanner;
import java.io.IOException;

public class GameMethods {
  /*
  public static String[][] makeGameBoard() {
    String[][] gameBoard = {
        {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"},
        {"A", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"B", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"C", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"D", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"E", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"F", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"G", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"H", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"I", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"},
        {"J", "~", "~", "~", "~", "~", "~", "~", "~", "~", "~"}
    };
    return gameBoard;
  }

  public static void printGameBoard(String[][] gameBoard) {
    for (String[] strings : gameBoard) {
      for (String string : strings) {
        System.out.print(string + " ");
      }
      System.out.println();
    }
  }
*/

  //------------ start check ship length method ---------------//
  public static boolean shipLengthOK(String[] givenCoord, String shipType, int shipLength) {
    boolean isShipLengthOK = false;
    int coordinateLength;

    String coordinate1 = givenCoord[0];
    String coordinate2 = givenCoord[1];


    String[] coord1 = coordinate1.split("(?<=\\D)(?=\\d)");
    String[] coord2 = coordinate2.split("(?<=\\D)(?=\\d)");

    String startLetter = coord1[0].toLowerCase();
    String endLetter = coord2[0].toLowerCase();

    if (startLetter.charAt(0) > endLetter.charAt(0)) {
      startLetter = coord2[0].toLowerCase();
      endLetter = coord1[0].toLowerCase();
    }

    int startCol = Integer.parseInt(coord1[1]);
    int endCol = Integer.parseInt(coord2[1]);

    if (startCol > endCol) {
      startCol = Integer.parseInt(coord2[1]);
      endCol = Integer.parseInt(coord1[1]);
    }

    if (startLetter.equals(endLetter)) {
      //then ship placement is horizontal
      coordinateLength = Math.abs(endCol - startCol) + 1;
      if (coordinateLength == shipLength) {
        isShipLengthOK = true;
      } else if (coordinateLength != shipLength) {
        System.out.println("Error! Wrong length of the " + shipType + "! Try again:");
        isShipLengthOK = false;
      }
    } else if (startCol == endCol) {
      //then ship placement is vertical
      coordinateLength = endLetter.charAt(0) - startLetter.charAt(0) + 1;
      if (coordinateLength == shipLength) {
        isShipLengthOK = true;
      } else if (coordinateLength != shipLength) {
        System.out.println("Error! Wrong length of the " + shipType + "! Try again:");
        isShipLengthOK = false;
      }
    }
    return isShipLengthOK;
  }

  //--------- end check ship length method -------------//

  //---------- start perimeter check around proposed ship placement -------------//
  public static Boolean checkCoordOk(String[] givenCoord, PlayingGrid gameBoard) {
    //check to make sure coordinates are either horizontal or vertical first
    boolean isCheckAdj = false;
    boolean isCheckAbvBelow = false;
    boolean isCheckOK = false;

    String coordinate1 = givenCoord[0];
    String coordinate2 = givenCoord[1];


    String[] coord1 = coordinate1.split("(?<=\\D)(?=\\d)");
    String[] coord2 = coordinate2.split("(?<=\\D)(?=\\d)");

    String startLetter = coord1[0].toLowerCase();
    String endLetter = coord2[0].toLowerCase();

    if (startLetter.charAt(0) > endLetter.charAt(0)) {
      startLetter = coord2[0].toLowerCase();
      endLetter = coord1[0].toLowerCase();
    }

    int startRow = 0;
    switch (startLetter) {
      case "a":
        startRow = 1;
        break;
      case "b":
        startRow = 2;
        break;
      case "c":
        startRow = 3;
        break;
      case "d":
        startRow = 4;
        break;
      case "e":
        startRow = 5;
        break;
      case "f":
        startRow = 6;
        break;
      case "g":
        startRow = 7;
        break;
      case "h":
        startRow = 8;
        break;
      case "i":
        startRow = 9;
        break;
      case "j":
        startRow = 10;
        break;
    }

    int endRow = 0;
    switch (endLetter) {
      case "a":
        endRow = 1;
        break;
      case "b":
        endRow = 2;
        break;
      case "c":
        endRow = 3;
        break;
      case "d":
        endRow = 4;
        break;
      case "e":
        endRow = 5;
        break;
      case "f":
        endRow = 6;
        break;
      case "g":
        endRow = 7;
        break;
      case "h":
        endRow = 8;
        break;
      case "i":
        endRow = 9;
        break;
      case "j":
        endRow = 10;
        break;
    }

    int startCol = Integer.parseInt(coord1[1]);
    int endCol = Integer.parseInt(coord2[1]);

    if (startCol > endCol) {
      startCol = Integer.parseInt(coord2[1]);
      endCol = Integer.parseInt(coord1[1]);
    }


    // start if-block for horizontal ship placements
    if (startLetter.equals(endLetter)) { //need to check game board to make sure there are no other ships with adjacent occupied cells
      if (startCol == 1) { // only check the right side to avoid checking out of bounds
        if ("0".equals(gameBoard.getGridCell(startRow, endCol).getNextHorizontalCell().getStatus())) {
          System.out.println("Error! You placed it too close to another one. Try again:");
          isCheckAdj = false;
        } else {
          isCheckAdj = true;
        }
      } else if (endCol == 10) {  // only check the left side
        if ("0".equals(gameBoard.getGridCell(startRow, startCol).getPrevHorizontalCell().getStatus())) {
          System.out.println("Error! You placed it too close to another one. Try again:");
          isCheckAdj = false;
        } else {
          isCheckAdj = true;
        }
      } else if (startCol > 1 && endCol < 10) { //check left and right side of horizontal placement
        if ("O".equals((gameBoard.getGridCell(startRow, startCol - 1).getStatus())) || "O"
            .equals((gameBoard.getGridCell(startRow, endCol + 1).getStatus()))) {
          System.out.println("Error! You placed it too close to another one. Try again:");
          isCheckAdj = false;
        } else {
          isCheckAdj = true;
        }
      }

      //horizontal checks above and below a horizontally placed ship
      if (startRow == 1) { // only check row below ship
        for (int i = startCol; i <= endCol; i++) {
          if ("O".equals(gameBoard.getGridCell(startRow + 1, i).getStatus())) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            isCheckAbvBelow = false;
            break;
          } else {
            isCheckAbvBelow = true;
          }
        }
      } else if (startRow == 10) { // only check row above ship
        for (int i = startCol; i <= endCol; i++) {
          if ("O".equals(gameBoard.getGridCell(startRow - 1, i).getStatus())) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            isCheckAbvBelow = false;
            break;
          } else {
            isCheckAbvBelow = true;
          }
        }
      } else if (startRow > 1 && endRow < 10) {
        for (int i = startCol; i <= endCol; i++) {
          if ("O".equals((gameBoard.getGridCell(startRow - 1, i).getStatus())) || "O".equals((gameBoard.getGridCell(startRow + 1 , i).getStatus()))) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            isCheckAbvBelow = false;
            break;
          } else {
            isCheckAbvBelow = true;
          }
        }
      }
    } // end if-block of horizontal ship checks

    // Start of if-block for vertical ship placements
    if (startCol == endCol) { // ship is placed vertically (columns are the same)
      if (startRow == 1) { // avoids checking out of bounds above row "a"
        if ("O".equals(gameBoard.getGridCell(endRow + 1, startCol).getStatus())) {
          System.out.println("Error! You placed it too close to another one. Try again:");
          isCheckAbvBelow = false;
        } else {
          isCheckAbvBelow = true;
        }
      } else if (endRow == 10) { // avoids checking below row "j" out of bounds
        if ("O".equals(gameBoard.getGridCell(startRow - 1, startCol).getStatus())) {
          System.out.println("Error! You placed it too close to another one. Try again:");
          isCheckAbvBelow = false;
        } else {
          isCheckAbvBelow = true;
        }
      }
      if (startRow > 1 && endRow < 10) { // check above and below vertically ships
        if ("O".equals((gameBoard.getGridCell(startRow - 1, startCol).getStatus())) || "O"
            .equals((gameBoard.getGridCell(endRow + 1, startCol).getStatus()))) {
          System.out.println("Error! You placed it too close to another one. Try again:");
          isCheckAbvBelow = false;
        } else {
          isCheckAbvBelow = true;
        }
      }

      // check each side of the vertically placed ship
      if (startCol == 1) {  // only check to the right of the vertically placed ship
        for (int i = startRow; i <= endRow; i++) {
          if ("O".equals(gameBoard.getGridCell(i, startCol).getNextHorizontalCell().getStatus())) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            isCheckAdj = false;
            break;
          } else {
            isCheckAdj = true;
          }
        }
      } else if (endCol == 10) { // only check to the left side of the vertically placed ship
        for (int i = startRow; i <= endRow; i++) {
          if ("O".equals((gameBoard.getGridCell(i, startCol - 1).getStatus()))) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            isCheckAdj = false;
            break;
          } else {
            isCheckAdj = true;
          }
        }
      } else if (startCol > 1 && endCol < 10) {  //check both sides of vertically placed ship
        for (int i = startRow; i <= endRow; i++) {
          if ("O".equals((gameBoard.getGridCell(i, startCol - 1).getStatus())) || "O".equals((gameBoard.getGridCell(i, startCol + 1).getStatus()))) {
            System.out.println("Error! You placed it too close to another one. Try again:");
            isCheckAdj = false;
            break;
          } else {
            isCheckAdj = true;
          }
        }
      }
    }
    if (isCheckAdj && isCheckAbvBelow) {
      isCheckOK = true;
    }
    return isCheckOK;
  }
  //--------------- end perimeter check ----------------//

  //---------------- ship placement method -------------//
  public static void placeShip(String[] givenCoord, PlayingGrid gameB, String shipType) {  // need to also set shipType here
    PlayingGrid gb = gameB;
    String coordinate1 = givenCoord[0];
    String coordinate2 = givenCoord[1];

    String[] coord1 = coordinate1.split("(?<=\\D)(?=\\d)");
    String[] coord2 = coordinate2.split("(?<=\\D)(?=\\d)");

    String startLetter = coord1[0].toLowerCase();
    String endLetter = coord2[0].toLowerCase();

    if (startLetter.charAt(0) > endLetter.charAt(0)) {
      startLetter = coord2[0].toLowerCase();
      endLetter = coord1[0].toLowerCase();
    }

    int startCol = Integer.parseInt(coord1[1]);
    int endCol = Integer.parseInt(coord2[1]);

    if (startCol > endCol) {
      startCol = Integer.parseInt(coord2[1]);
      endCol = Integer.parseInt(coord1[1]);
    }

    int startRow = 0;
    switch (startLetter) {
      case "a":
        startRow = 1;
        break;
      case "b":
        startRow = 2;
        break;
      case "c":
        startRow = 3;
        break;
      case "d":
        startRow = 4;
        break;
      case "e":
        startRow = 5;
        break;
      case "f":
        startRow = 6;
        break;
      case "g":
        startRow = 7;
        break;
      case "h":
        startRow = 8;
        break;
      case "i":
        startRow = 9;
        break;
      case "j":
        startRow = 10;
        break;
    }

    int endRow = 0;
    switch (endLetter) {
      case "a":
        endRow = 1;
        break;
      case "b":
        endRow = 2;
        break;
      case "c":
        endRow = 3;
        break;
      case "d":
        endRow = 4;
        break;
      case "e":
        endRow = 5;
        break;
      case "f":
        endRow = 6;
        break;
      case "g":
        endRow = 7;
        break;
      case "h":
        endRow = 8;
        break;
      case "i":
        endRow = 9;
        break;
      case "j":
        endRow = 10;
        break;
    }

    if (startLetter.equals(endLetter)) { // horizontal placement
      //change the appropriate horizontal array elements in the game board
      for (int i = startCol; i <= endCol; i++ ) {
        gb.setGridCellStatus(startRow, i, "O", shipType);
        //System.out.println("Game Methods placeship() Placing ship of type: " + shipType);
      }
    }

    if (startCol == endCol) { //vertical placement
      for (int i = startRow; i <= endRow; i++) { //change vertical elements to "O"
        gb.setGridCellStatus(i, startCol,"O", shipType);
        //System.out.println("Game Methods placeship() Placing ship of type: " + shipType);
      }
    }
  }
  //--------------- end ship placement method -------------------//


  //--------------- start enter ship coordinates for placing ships on game board ------//
  public static String[] enterShip(String shipType, PlayingGrid gameBoard) {
    Scanner scanner = new Scanner(System.in);
    boolean isCoordPlacementOk = false;
    boolean isShipLengthOk = false;
    int shipLength = 0;
    PlayingGrid gb = gameBoard;

    switch (shipType) {
      case "Aircraft Carrier":
        shipLength = 5;
        break;
      case "Battleship":
        shipLength = 4;
        break;
      case "Submarine":
        shipLength = 3;
        break;
      case "Cruiser":
        shipLength = 3;
        break;
      case "Destroyer":
        shipLength = 2;
        break;
    }

    String[] givenCoord = new String[2];
    while(!isCoordPlacementOk || !isShipLengthOk) {
      System.out.println();
      System.out.println("Enter the coordinates of the " + shipType + " (" + shipLength + " cells):");
      System.out.print(">");
      givenCoord = scanner.nextLine().split("[\\s+]");
      try {
        isCoordPlacementOk = checkCoordOk(givenCoord, gb);
      } catch (Exception e) {
        System.out.println("Input error...");
      }

      try {
        isShipLengthOk = shipLengthOK(givenCoord, shipType, shipLength);
      } catch (Exception e) {
        //e.printStackTrace();
        System.out.println("Input error...");
      }
      if (isCoordPlacementOk && isShipLengthOk) {
        //System.out.println("Safe to place ship!");
        placeShip(givenCoord, gb, shipType);
      } else {
        //System.out.println("Not able to place ship. Error!");
        System.out.println();
      }
    }
    return givenCoord;
  }

  public static void promptEnterKey() {
    System.out.println("Press Enter and pass the move to another player");
    try {
      System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
