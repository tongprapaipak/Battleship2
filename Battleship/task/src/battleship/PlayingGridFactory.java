package battleship;
import java.util.ArrayList;
import java.util.*;

public class PlayingGridFactory {

  //Attributes

  private List<PlayingGrid> ThePlayingGrid = new ArrayList<PlayingGrid>();

  //Roles

  private static PlayingGridFactory Instance;
  private PlayingGrid[] rPlayingGrid;

  //Operations

  public static PlayingGridFactory getInstance() {
    if (Instance == null) {
      Instance = new PlayingGridFactory();
    }
    return Instance;
  }

  public PlayingGrid GetPlayingGrid(final int PlayerNumber) {
    int i;
    Boolean Found = false;
    PlayingGrid thisGrid = null;

    // Loop through the lists and see if this player's board has been created yet.
    //If yes, return that instance of the playing board, otherwise make a new playing board for this player and add it to the list
    //and return the new playing board.

    for (i=0; i < this.ThePlayingGrid.size(); i++) {
      if (this.ThePlayingGrid.get(i).getPlayerNumber() == PlayerNumber) {
        thisGrid = this.ThePlayingGrid.get(i);
        Integer x = thisGrid.getPlayerNumber();
        Found = true;
      }
    }

    if (!Found) {
      thisGrid = new PlayingGrid(PlayerNumber);
      this.ThePlayingGrid.add(thisGrid);
    }
    return thisGrid;
  }
}
