package frogger.model.actor;

/** Horizontal moving cars in the game. */
public class Car extends AutomaticActor {
  public Car(String imageLink, int xpos, int ypos, int width, double speed) {
    super(imageLink, xpos, ypos, width, width, speed);
    setEdge(-75, -200);
  }
}
