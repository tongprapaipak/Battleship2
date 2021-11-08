package battleship;

import java.util.ArrayList;
import java.util.List;


public class AddBoats<Boats> {



  public static List<Boat> addBoats (PlayingGrid playersGameBoard, String player) {

    String[] givenCoord;
    ArrayList<Boat> Boats = new ArrayList<>();

    //Create an airCraftCarrier
    String aircraftCarrier = "Aircraft Carrier";
    givenCoord = GameMethods.enterShip(aircraftCarrier, playersGameBoard);
    AircraftCarrier airC = new AircraftCarrier("Aircraft Carrier1", "airCraftCarrier", player, 5, givenCoord, "active", 0);
    Boats.add(airC);
    //System.out.println(Arrays.toString(airC.getPosition()));
    System.out.println(player + " Game Board:");
    playersGameBoard.printGameBoard();


    //Create a Battleship
    String battleShip = "Battleship";
    givenCoord = GameMethods.enterShip(battleShip, playersGameBoard);
    Battleship bs = new Battleship("Battleship1", player, 4, givenCoord, "active", 0);
    Boats.add(bs);
    //System.out.println(Arrays.toString(bs.getPosition()));
    System.out.println();
    System.out.println(player + " Game Board:");
    playersGameBoard.printGameBoard();

    //Create a Submarine
    String submarine = "Submarine";
    givenCoord = GameMethods.enterShip(submarine, playersGameBoard);
    Submarine sub = new Submarine("Submarine1", player, 3, givenCoord, "active", 0);
    Boats.add(sub);
    //System.out.println(Arrays.toString(sub.getPosition()));
    System.out.println(player + " Game Board:");
    playersGameBoard.printGameBoard();


    //Create a Cruiser
    String cruiser = "Cruiser";
    givenCoord = GameMethods.enterShip(cruiser, playersGameBoard);
    Cruiser cr = new Cruiser("cruiser1", player, 3, givenCoord, "active", 0);
    Boats.add(cr);
    //System.out.println(Arrays.toString(cr.getPosition()));
    System.out.println(player + " Game Board:");
    playersGameBoard.printGameBoard();


    //Create a Destroyer
    String destroyer = "Destroyer";
    givenCoord = GameMethods.enterShip(destroyer, playersGameBoard);
    Destroyer des = new Destroyer("destroyer1", player, 2, givenCoord, "active", 0);
    Boats.add(des);
    //System.out.println(Arrays.toString(des.getPosition()));
    System.out.println(player + " Game Board:");

    playersGameBoard.printGameBoard();


    return Boats;
  }


}
