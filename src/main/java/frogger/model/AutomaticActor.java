package frogger.model;

public abstract class AutomaticActor extends Actor {
  private double speed;

  public AutomaticActor(String imageLink, int xpos, int ypos, int width, int height, double speed) {
    super(imageLink, xpos, ypos, width, height);
    setSpeed(speed);
  }

  public void setSpeed(double speed) {
    this.speed = speed;
  }

  public double getSpeed() {
    return speed;
  }

  @Override
  public void act(long now) {
    move(speed, 0);
    if (getX() > 600 && speed > 0) setX(-200);
    if (getX() < -75 && speed < 0) setX(600);
  }
}
