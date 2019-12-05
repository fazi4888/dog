package frogger.model;

public abstract class AutomaticActor extends Actor {

  private double speed;
  private int edgeLeft;
  private int edgeRight;

  public AutomaticActor(String imageLink, int xpos, int ypos, int width, int height, double speed) {
    super(imageLink, xpos, ypos, width, height);
    this.speed = speed;
  }

  public void setEdge(int left, int right) {
    this.edgeLeft = left;
    this.edgeRight = right;
  }

  @Override
  public void act(long now) {
    move(speed, 0);
    resetPos();
  }

  private void resetPos() {
    if (getX() > 768 && speed > 0) setX(edgeRight);
    if (getX() < edgeLeft && speed < 0) setX(768);
  }
}
