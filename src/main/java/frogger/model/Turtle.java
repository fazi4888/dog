package frogger.model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Turtle extends AutomaticActor implements Transformable {

  private ArrayList<Image> turtleStates;

  public Turtle(String imageLink, int xpos, int ypos, int width, double speed) {
    super(imageLink, xpos, ypos, width, width, speed);
    initTurtleState(width);
  }

  @Override
  public void act(long now) {
    super.act(now);
    transform(now);
  }

  @Override
  public void transform(long now) {
    int stateIndex = (int) (now / 900000000 % 3);
    setImage(turtleStates.get(stateIndex));
  }

  private void initTurtleState(int width) {
    turtleStates =
        new ArrayList<>() {
          {
            add(new Image("/frogger/image/turtle/TurtleAnimation1.png", width, width, true, true));
            add(new Image("/frogger/image/turtle/TurtleAnimation2.png", width, width, true, true));
            add(new Image("/frogger/image/turtle/TurtleAnimation3.png", width, width, true, true));
          }
        };
  }
}
