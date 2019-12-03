package frogger.model;

public class Car extends AutomaticActor {
  private int speed;

  public Car(String imageLink, int xpos, int ypos, int width, int height, double speed) {
    super(imageLink, xpos, ypos, width, height, speed);
  }

  @Override
  public void act(long now) {
    move(speed, 0);
    if (getX() > 600 && speed > 0) setX(-200);
    if (getX() < -50 && speed < 0) setX(600);
  }
}
