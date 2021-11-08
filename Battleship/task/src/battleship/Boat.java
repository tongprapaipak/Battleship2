package battleship;

public class Boat {

  //constructors
  private String type;
  private String name;
  //private String player;
  private int length;




  public Boat(String type, String name) {
    this.type = type;
    this.name = name;
    this.length = length;

  }


  //methods
  public String getShipType() {
    return type;
  }

  public String getShipName() {
    return name;
  }

  public int getLength() {
    return length;
  }

  public void setStatus(String status) {

  }

  public void setDamageReport() {

  }

  public int getDamageReport() {
    return 0;
  }

}
