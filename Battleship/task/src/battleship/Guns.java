package battleship;
import java.util.Scanner;

public class Guns {

  public static boolean checkTargetRange(String target) {

    boolean isTargetRangeOK = false;

    String[] coord1 = target.split("(?<=\\D)(?=\\d)");
    String startLetter = coord1[0].toLowerCase();
    char charLetter = startLetter.charAt(0);
    //System.out.println("Test In Guns: " + charLetter);
    int startCol = Integer.parseInt(coord1[1]);

    if (charLetter > 'j' || startCol > 10) {
      System.out.println("Error! You entered the wrong coordinates! Try again:");
      isTargetRangeOK = false;
    } else {
      isTargetRangeOK = true;
    }
    return isTargetRangeOK;
  }

  public static String shootGun(PlayingGrid gameBoard) {

    boolean isHit = false;
    String shipType = null;
    boolean isMiss = false;
    boolean isGunFired = false;
    boolean isTargetCoordOK = false;
    String targetCoord = "";
    Scanner scanner = new Scanner(System.in);
    while (!isTargetCoordOK) {
      //System.out.print("> ");
      targetCoord = scanner.nextLine();
      isTargetCoordOK = checkTargetRange(targetCoord);
    }

    String[] coord1 = targetCoord.split("(?<=\\D)(?=\\d)");
    String startLetter = coord1[0].toLowerCase();
    char charLetter = startLetter.charAt(0);
    int startCol = Integer.parseInt(coord1[1]);

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

    String status = gameBoard.getGridCell(startRow, startCol).getStatus();
    //System.out.println("Guns get status: " + status);
    if (!isHit) {
      if ("O".equals(status)) {
        // successful hit
        shipType = gameBoard.getGridCell(startRow,startCol).getShipType();
        //System.out.println("printing Shiptype from guns class: " + shipType);
        gameBoard.setGridCellStatus(startRow, startCol, "X", shipType);
        //System.out.println("You hit a ship!");
        //GameMethods.promptEnterKey();
        //System.out.println("Press Enter and pass the move to another player");
        //System.out.println("Ship Type Hit: " + shipType);
        //gameBoard.printHiddenGameBoard();
        //if direct hit, need to check status of ship hit.  Also need to know which ship was hit
        //isHit = true;
        //isGunFired = true;
      } else if ("~".equals(status)) {
        shipType = gameBoard.getGridCell(startRow,startCol).getShipType();
        gameBoard.setGridCellStatus(startRow, startCol, "M", shipType);
        //gameBoard.printHiddenGameBoard();
        //System.out.println();
        System.out.println("You missed!");
        GameMethods.promptEnterKey();
        //System.out.println();
        //gameBoard.printGameBoard();
        isHit = true;
      } else if ("X".equals(status)) { // should change this to state you already chose this coordinate
        shipType = gameBoard.getGridCell(startRow,startCol).getShipType();
        gameBoard.setGridCellStatus(startRow, startCol, "X", shipType);
        //gameBoard.printHiddenGameBoard();
        //System.out.println("You hit a ship!");
        //GameMethods.promptEnterKey();
        System.out.println();
        isHit = true;
      }
    }
    return shipType;
  }


}
