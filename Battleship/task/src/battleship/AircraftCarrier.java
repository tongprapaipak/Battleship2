package battleship;

public class AircraftCarrier extends Boat {

  //constructors


  private String name;
  private String player;
  private int length;
  private String[] position;
  private String status; //active or destroyed
  private int damageReport; //scale of 1 to 5.  When damage == length - 1, status == destroyed
  private String shipType;
  String[] aircraftCoordinates = new String[5];




  public AircraftCarrier(String name, String shipType, String player, int length, String[] position,
      String status, int damageReport) {
    super("airCraftCarrier", "Aircraft Carrier");
    this.position = position;
    this.status = status;
    this.damageReport = damageReport;


    String coordinate1 = position[0];
    String coordinate2 = position[1];


    String[] coord1 = coordinate1.split("(?<=\\D)(?=\\d)");
    String[] coord2 = coordinate2.split("(?<=\\D)(?=\\d)");

    String startLetter = coord1[0].toLowerCase();
    String endLetter = coord2[0].toLowerCase();

    int startNum = Integer.parseInt(coord1[1]);
    int endNum = Integer.parseInt(coord2[1]);

    if (startLetter.equals(endLetter)) {
      for (int x = 0; x <= 4; x++ ) {
        aircraftCoordinates[x] = startLetter + startNum;
        startNum++;
      }
    } else if (startNum == endNum) {
      int x = 0;
      for (char c = startLetter.charAt(0); c <= endLetter.charAt(0); c++) {
        aircraftCoordinates[x] = String.valueOf(c) + endNum;
        x++;
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
    return aircraftCoordinates;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {this.status = status;}

  public void setDamageReport() {
    System.out.println("You hit a boat!!");
    this.damageReport++;
  }

  public int getDamageReport() {
    return damageReport;
  }

  public int getLength() {
    return length;
  }

  public String getShipType() {
    return shipType;
  }
}
