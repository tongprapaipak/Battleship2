package battleship;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        System.out.println("Player 1, place your ships on the game field");
        System.out.println("");

        PlayingGrid gameBoard = new PlayingGrid(1);
        gameBoard.associateCell();  //creates all the instances of each cell inside the PlayingGrid
        gameBoard.printGameBoard(); //prints the game board to console
        ArrayList<Boat> player1Boats;
        player1Boats = (ArrayList<Boat>) AddBoats.addBoats(gameBoard,"Player1");
        System.out.println();

        GameMethods.promptEnterKey();
        System.out.println();

        System.out.println("Player 2, place your ships on the game field");
        System.out.println();

        PlayingGrid gameBoard2 = new PlayingGrid(2);
        gameBoard2.associateCell();
        gameBoard2.printGameBoard();
        ArrayList<Boat> player2Boats;
        player2Boats = (ArrayList<Boat>) AddBoats.addBoats(gameBoard2,"Player2");

        System.out.println("Press Enter and pass the move to another player");
        System.out.println();

        //Start game play...
        GamePlay.playerTurn(gameBoard, gameBoard2, player1Boats, player2Boats);

    }
}
