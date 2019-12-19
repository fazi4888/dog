package frogger.model.actor;

import frogger.constant.FileName;
import javafx.scene.image.Image;

import java.util.ArrayList;

/** Horizontal moving wet turtles in the game. */
public class WetTurtle extends AutomaticActor implements Transformable {

  /** If the wet turtle is sunk. */
  private boolean sunk = false;

  /** The image of different states of the wet turtle. */
  private ArrayList<Image> turtleStates;

  public WetTurtle(String imageLink, int xpos, int ypos, int width, double speed) {
    super(imageLink, xpos, ypos, width, width, speed);
    setEdge(-75, -200);
    initTurtleState(width);
  }

  @Override
  public void resetActor() {
    super.resetActor();
    setImage(turtleStates.get(0));
  }

  public boolean isSunk() {
    return sunk;
  }

  /**
   * Transform the state of the wet turtle.
   *
   * @param now the timestamp of the current frame given in nanoseconds
   * @see #transform(long)
   */
  @Override
  public void act(long now) {
    super.act(now);
    transform(now);
  }

  /** Transform the state of the wet turtle. */
  @Override
  public void transform(long now) {
    int stateIndex = (int) (now / 900000000 % 4);
    setImage(turtleStates.get(stateIndex));
    sunk = stateIndex == 3;
  }

  private void initTurtleState(int width) {
    turtleStates =
        new ArrayList<>() {
          {
            add(new Image(FileName.IMAGE_WETTURTLE_1, width, width, true, true));
            add(new Image(FileName.IMAGE_WETTURTLE_2, width, width, true, true));
            add(new Image(FileName.IMAGE_WETTURTLE_3, width, width, true, true));
            add(new Image(FileName.IMAGE_WETTURTLE_4, width, width, true, true));
          }
        };
  }
}
