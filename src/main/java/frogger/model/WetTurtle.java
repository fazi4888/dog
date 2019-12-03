package frogger.model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class WetTurtle extends AutomaticActor implements Transformable {

  private boolean sunk = false;
  private ArrayList<Image> turtleStates;

  public WetTurtle(String imageLink, int xpos, int ypos, int width, double speed) {
    super(imageLink, xpos, ypos, width, width, speed);
    initTurtleState(width);
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
            add(new Image("/frogger/image/turtle/TurtleAnimation2Wet.png", width, width, true, true));
            add(new Image("/frogger/image/turtle/TurtleAnimation1.png", width, width, true, true));
            add(new Image("/frogger/image/turtle/TurtleAnimation3Wet.png", width, width, true, true));
            add(new Image("/frogger/image/turtle/TurtleAnimation4Wet.png", width, width, true, true));
          }
        };
  }
}
