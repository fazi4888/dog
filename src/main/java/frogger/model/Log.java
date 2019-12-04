package frogger.model;

public class Log extends AutomaticActor {

  private double speed;

  @Override
  public void act(long now) {
    move(speed, 0);
    if (getX() > 600 && speed > 0)
      setX(-180);
    if (getX() < -300 && speed < 0)
      setX(700);
  }

  public Log(String imageLink, int size, int xpos, int ypos, double speed) {
    super(imageLink, xpos, ypos, size, 40, speed);
  }

  public boolean getLeft() {
    return speed < 0;
  }
}
