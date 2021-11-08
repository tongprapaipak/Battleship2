package battleship;

public class Destroyer extends Boat {

  //constructors


  private String name;
  private String player;
  private int length;
  private String[] position;
  private String status; //active or destroyed
  private int damageReport; //scale of 1 to 2.  1hen damage == length - 1, status == destroyed
  String[] destroyerCoordinates = new String[2];




  public Destroyer(String name, String player, int length, String[] position,
      String status, int damageReport) {
    super("destroyer", "Destroyer1");
    this.position = position;
    this.status = status;
    this.damageReport = damageReport;


    String coordinate1 = position[0];
    String coordinate2 = position[1];
    //System.out.println("Inside constructor: " + coordinate1 + " " + coordinate2);

    String[] coord1 = coordinate1.split("(?<=\\D)(?=\\d)");
    String[] coord2 = coordinate2.split("(?<=\\D)(?=\\d)");

    String startLetter = coord1[0].toLowerCase();
    String endLetter = coord2[0].toLowerCase();

    int startNum = Integer.parseInt(coord1[1]);
    int endNum = Integer.parseInt(coord2[1]);

    if (startLetter.equals(endLetter)) {
      for (int i = 0; i <= 1; i++ ) {
        destroyerCoordinates[i] = startLetter + startNum;
        startNum++;
      }
    } else if (startNum == endNum) {
      int i = 0;
      for (char c = startLetter.charAt(0); c <= endLetter.charAt(0); c++) {
        destroyerCoordinates[i] = String.valueOf(c) + endNum;
        i++;
      }
    }
  }

  //methods

  public String getShipName() {
    return name;
  }

  public String getPlayer() {
    return player;
  }

  public String[] getPosition() {
    return destroyerCoordinates;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {this.status = status;}

  public void setDamageReport() {this.damageReport++;}

  public int getDamageReport() {
    return damageReport;
  }

  public int getLength() {
    return length;
  }

}
