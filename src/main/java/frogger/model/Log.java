package frogger.model;

public class Log extends AutomaticActor {
  public Log(String imageLink, int size, int xpos, int ypos, double speed) {
    super(imageLink, xpos, ypos, size, 40, speed);
    setEdge(-300, -180);
  }
}
