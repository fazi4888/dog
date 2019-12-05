package frogger.model.actor;

import frogger.constant.FileName;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Turtle extends AutomaticActor implements Transformable {

  private ArrayList<Image> turtleStates;

  public Turtle(String imageLink, int xpos, int ypos, int width, double speed) {
    super(imageLink, xpos, ypos, width, width, speed);
    setEdge(-75, -200);
    initTurtleState(width);
  }

  @Override
  public void resetActor() {
    super.resetActor();
    setImage(turtleStates.get(1));
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
            add(new Image(FileName.IMAGE_TURTLE_1, width, width, true, true));
            add(new Image(FileName.IMAGE_TURTLE_2, width, width, true, true));
            add(new Image(FileName.IMAGE_TURTLE_3, width, width, true, true));
          }
        };
  }
}
