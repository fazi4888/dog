package frogger.model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Turtle extends Movable {

  ArrayList<Image> turtleStates;

  private int speed;

  @Override
  public void act(long now) {
    setImage(turtleStates.get((int) ((now / 900000000) % 3)));

    move(speed, 0);
    if (getX() > 600 && speed > 0) setX(-200);
    if (getX() < -75 && speed < 0) setX(600);
  }

  public Turtle(int xpos, int ypos, int speed, int width) {
    turtleStates =
        new ArrayList<>() {
          {
            add(new Image("/frogger/image/turtle/TurtleAnimation1.png", width, width, true, true));
            add(new Image("/frogger/image/turtle/TurtleAnimation2.png", width, width, true, true));
            add(new Image("/frogger/image/turtle/TurtleAnimation3.png", width, width, true, true));
          }
        };
    setX(xpos);
    setY(ypos);
    this.speed = speed;
    setImage(turtleStates.get(1));
  }
}
