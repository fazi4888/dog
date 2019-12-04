package frogger.model;

public class Car extends AutomaticActor {
  public Car(String imageLink, int xpos, int ypos, int width, double speed) {
    super(imageLink, xpos, ypos, width, width, speed);
    setEdge(-75, -210);
  }
}
