package frogger.model.actor;

import frogger.constant.FileName;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class WetTurtle extends AutomaticActor implements Transformable {

  private boolean sunk = false;
  private ArrayList<Image> turtleStates;

  public WetTurtle(String imageLink, int xpos, int ypos, int width, double speed) {
    super(imageLink, xpos, ypos, width, width, speed);
    setEdge(-75, -200);
    initTurtleState(width);
  }

  @Override
  public void reset() {
    super.reset();
    setImage(turtleStates.get(0));
  }

  public boolean isSunk() {
    return sunk;
  }

  @Override
  public void act(long now) {
    super.act(now);
    transform(now);
  }

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
