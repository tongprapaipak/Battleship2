package battleship;

import java.util.ArrayList;

public class GamePlay {


  public static void playerTurn(PlayingGrid player1Board, PlayingGrid player2Board, ArrayList<Boat> player1BoatList, ArrayList<Boat> player2BoatList) {
    boolean gameOver = false;
    int player1ShipsDestroyed = 0;
    int player2ShipsDestroyed = 0;

    //Starting Game
    GameMethods.promptEnterKey();
    System.out.println();


    while (player1ShipsDestroyed < 5 || player2ShipsDestroyed < 5) {
      player2Board.printHiddenGameBoard();
      System.out.println("---------------------");
      player1Board.printGameBoard();
      //player 1 shoots first at player 2s game board
      System.out.println("Player 1, it's your turn:");
      System.out.println();
      String isPlayer2Hit = Guns.shootGun(player2Board);
      //System.out.println("test: " + isPlayer2Hit);


      if ("Aircraft Carrier".equals(isPlayer2Hit)) {
        AircraftCarrier player2_AirCr = (AircraftCarrier) player2BoatList.get(0);
        player2_AirCr.setDamageReport();
        //System.out.println("Boat Status: " + player2_AirCr.getStatus());
        //System.out.println("Damage Report: " + player2_AirCr.getDamageReport());
        if (player2_AirCr.getDamageReport() == 5) {
          player2ShipsDestroyed++;
          player2_AirCr.setStatus("destroyed");
          //System.out.println("Boat Status: " + player2_AirCr.getStatus());
          if (player2ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }
      }
      if ("Battleship".equals(isPlayer2Hit)) {
        Battleship player2_Bs = (Battleship) player2BoatList.get(1);
        player2_Bs.setDamageReport();

        if (player2_Bs.getDamageReport() == 4) {
          player2ShipsDestroyed++;
          player2_Bs.setStatus("destroyed");
          if (player2ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }

      }

      if ("Submarine".equals(isPlayer2Hit)) {
        Submarine player2_Sub = (Submarine) player2BoatList.get(2);
        player2_Sub.setDamageReport();

        if (player2_Sub.getDamageReport() == 3) {
          player2ShipsDestroyed++;
          player2_Sub.setStatus("destroyed");
          if (player2ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }
      }

      if ("Cruiser".equals(isPlayer2Hit)) {
        Cruiser player2_Cr = (Cruiser) player2BoatList.get(3);
        player2_Cr.setDamageReport();

        if (player2_Cr.getDamageReport() == 3) {
          player2ShipsDestroyed++;
          player2_Cr.setStatus("destroyed");
          if (player2ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }
      }

      if ("Destroyer".equals(isPlayer2Hit)) {
        Destroyer player2_Des = (Destroyer) player2BoatList.get(4);
        player2_Des.setDamageReport();

        if (player2_Des.getDamageReport() == 2) {
          player2ShipsDestroyed++;
          player2_Des.setStatus("destroyed");
          if (player2ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }
      }

      //player 2 shoots at player 1s game board
      player1Board.printHiddenGameBoard();
      System.out.println("---------------------");
      player2Board.printGameBoard();
      System.out.println("Player 2, it's your turn:");
      System.out.println();
      String isPlayer1Hit = Guns.shootGun(player1Board);
      //System.out.println("test: " + isPlayer1Hit);

      if ("Aircraft Carrier".equals(isPlayer1Hit)) {
        AircraftCarrier player1_AirCr = (AircraftCarrier) player1BoatList.get(0);
        player1_AirCr.setDamageReport();

        if (player1_AirCr.getDamageReport() == 5) {
          player1ShipsDestroyed++;
          player1_AirCr.setStatus("destroyed");
          if (player1ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }

      }
      if ("Battleship".equals(isPlayer1Hit)) {
        Battleship player1_Bs = (Battleship) player1BoatList.get(1);
        player1_Bs.setDamageReport();

        if (player1_Bs.getDamageReport() == 4) {
          player1ShipsDestroyed++;
          player1_Bs.setStatus("destroyed");

          if (player1ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }
      }

      if ("Submarine".equals(isPlayer1Hit)) {
        Submarine player1_Sub = (Submarine) player1BoatList.get(2);
        player1_Sub.setDamageReport();
        if (player1_Sub.getDamageReport() == 3) {
          player1ShipsDestroyed++;
          player1_Sub.setStatus("destroyed");
          if (player1ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }
      }

      if ("Cruiser".equals(isPlayer1Hit)) {
        Cruiser player1_Cr = (Cruiser) player1BoatList.get(3);
        player1_Cr.setDamageReport();
        if (player1_Cr.getDamageReport() == 3) {
          player1ShipsDestroyed++;
          player1_Cr.setStatus("destroyed");
          if (player1ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }
      }

      if ("Destroyer".equals(isPlayer1Hit)) {
        Destroyer player1_Des = (Destroyer) player1BoatList.get(4);
        player1_Des.setDamageReport();
        if (player1_Des.getDamageReport() == 2) {
          player1ShipsDestroyed++;
          player1_Des.setStatus("destroyed");
          if (player1ShipsDestroyed == 5) {
            System.out.println("You sank the last ship. You won. Congratulations!");
            System.exit(1);
          } else {
            System.out.println("You sank a ship!");
            GameMethods.promptEnterKey();
          }
        } else {
          System.out.println("You hit a ship!");
          GameMethods.promptEnterKey();
        }
      }
    }

  }
}
