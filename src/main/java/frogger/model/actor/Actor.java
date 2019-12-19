package frogger.model.actor;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The {@code Actor} is an abstract class which represents the actors in the game. e.g. frogs, logs,
 * cars and turtles....
 */
public abstract class Actor extends ImageView {

  /** The initial x coordinate of the actor. */
  private int xpos;
  /** The initial y coordinate of the actor. */
  private int ypos;

  /**
   * Constructs a new {@code Actor} with the specified parameters.
   *
   * @param imageLink the URL of the image of the actor
   * @param xpos the initial x coordinate of the actor
   * @param ypos the initial y coordinate of the actor
   * @param width the width of the actor
   * @param height the height of the actor
   */
  public Actor(String imageLink, int xpos, int ypos, int width, int height) {
    setImage(new Image(imageLink, width, height, true, true));
    this.xpos = xpos;
    this.ypos = ypos;
  }

  /** Resets the actor to the initial position. */
  public void resetActor() {
    setX(xpos);
    setY(ypos);
  }

  /**
   * Moves the actor according to the changes in x / y coordinate
   *
   * @param dx the changes in x coordinate
   * @param dy the changes in y coordinate
   */
  public void move(double dx, double dy) {
    setX(getX() + dx);
    setY(getY() + dy);
  }

  /**
   * Acts differently according to different extending classes.
   *
   * @param now the timestamp of the current frame given in nanoseconds
   * @see frogger.model.World
   */
  public abstract void act(long now);
}
