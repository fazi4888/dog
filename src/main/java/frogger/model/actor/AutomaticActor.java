package frogger.model.actor;

/**
 * The {@code AutomaticActor} is an abstract class which represents the actors which can not
 * controlled by the player. i.e. all actors exclude {@link Frog}
 */
public abstract class AutomaticActor extends Actor {

  /** The horizontal speed of the actor. */
  private double speed;

  /** */
  private int edgeLeft;
  /** */
  private int edgeRight;

  /**
   * Constructs a new {@code AutomaticActor} with the specified parameters.
   *
   * @param imageLink the URL of the image of the actor
   * @param xpos the initial x coordinate of the actor
   * @param ypos the initial y coordinate of the actor
   * @param width the width of the actor
   * @param height the height of the actor
   * @param speed the horizontal speed of the actor
   */
  public AutomaticActor(String imageLink, int xpos, int ypos, int width, int height, double speed) {
    super(imageLink, xpos, ypos, width, height);
    this.speed = speed;
  }

  /**
   * Returns the horizontal speed of the actor
   *
   * @return the horizontal speed of the actor
   */
  public double getSpeed() {
    return speed;
  }

  /**
   *
   * @param left
   * @param right
   */
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
    if (getX() > 576 && speed > 0) setX(edgeRight);
    if (getX() < edgeLeft && speed < 0) setX(576);
  }
}
