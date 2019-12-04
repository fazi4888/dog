package frogger.model;

import java.util.ArrayList;

import frogger.constant.Direction;
import frogger.constant.FileName;
import javafx.scene.image.Image;

public class Frog extends Actor {
  //  /*
  Image imgW;
  Image imgA;
  Image imgS;
  Image imgD;
  Image imgWJump;
  Image imgAJump;
  Image imgSJump;
  Image imgDJump;
  //   */
  int points = 0;
  int end = 0;
  private boolean isJumping = false;
  boolean isDeath = false;
  double movement = 34;
  double movementX = 20;
  int size = 50;
  boolean carDeath = false;
  boolean waterDeath = false;
  boolean stop = false;
  boolean changeScore = false;
  int carD = 0;
  double w = 800;
  ArrayList<End> inter = new ArrayList<End>();

  public Frog(String imageLink, int xpos) {
    super(imageLink, xpos, 965, 50, 50);
    initFrogStateImage();
  }

  private void initFrogStateImage() {
    imgW = new Image(FileName.IMAGE_FROG_PREFIX + "Up.png", size, size, true, true);
    imgA = new Image(FileName.IMAGE_FROG_PREFIX + "Left.png", size, size, true, true);
    imgS = new Image(FileName.IMAGE_FROG_PREFIX + "Down.png", size, size, true, true);
    imgD = new Image(FileName.IMAGE_FROG_PREFIX + "Right.png", size, size, true, true);
    imgWJump = new Image(FileName.IMAGE_FROG_PREFIX + "UpJump.png", size, size, true, true);
    imgAJump = new Image(FileName.IMAGE_FROG_PREFIX + "LeftJump.png", size, size, true, true);
    imgSJump = new Image(FileName.IMAGE_FROG_PREFIX + "DownJump.png", size, size, true, true);
    imgDJump = new Image(FileName.IMAGE_FROG_PREFIX + "RightJump.png", size, size, true, true);
  }

  public void jump(Direction direction, boolean isMoving) {
    if (isDeath) return;
    switch (direction) {
      case UP:
        move(0, -movement);
        setImage((isJumping) ? imgW : imgWJump);
        break;
      case LEFT:
        move(-movementX, 0);
        setImage((isJumping) ? imgA : imgAJump);
        break;
      case DOWN:
        move(0, movement);
        setImage((isJumping) ? imgS : imgSJump);
        break;
      case RIGHT:
        move(movementX, 0);
        setImage((isJumping) ? imgD : imgDJump);
        break;
    }
    isJumping = (isMoving) ? !isJumping : false;
  }

  /*
  @Override
  public void act(long now) {
    int bounds = 0;
    if (getY() < 0 || getY() > 734) {
      setX(300);
      setY(679.8 + movement);
    }
    if (getX() < 0) {
      move(movement * 2, 0);
    }
    if (carDeath) {
      isDeath = true;
      if ((now) % 11 == 0) {
        carD++;
      }
      if (carD == 1) {
        setImage(new Image("/frogger/image/death/cardeath1.png", size, size, true, true));
      }
      if (carD == 2) {
        setImage(new Image("/frogger/image/death/cardeath2.png", size, size, true, true));
      }
      if (carD == 3) {
        setImage(new Image("/frogger/image/death/cardeath3.png", size, size, true, true));
      }
      if (carD == 4) {
        setX(300);
        setY(679.8 + movement);
        carDeath = false;
        carD = 0;
        setImage(new Image("/frogger/image/frog/froggerUp.png", size, size, true, true));
        isDeath = false;
        if (points > 50) {
          points -= 50;
          changeScore = true;
        }
      }
    }
    if (waterDeath) {
      isDeath = true;
      if ((now) % 11 == 0) {
        carD++;
      }
      if (carD == 1) {
        setImage(new Image("/frogger/image/death/waterdeath1.png", size, size, true, true));
      }
      if (carD == 2) {
        setImage(new Image("/frogger/image/death/waterdeath2.png", size, size, true, true));
      }
      if (carD == 3) {
        setImage(new Image("/frogger/image/death/waterdeath3.png", size, size, true, true));
      }
      if (carD == 4) {
        setImage(new Image("/frogger/image/death/waterdeath4.png", size, size, true, true));
      }
      if (carD == 5) {
        setX(300);
        setY(679.8 + movement);
        waterDeath = false;
        carD = 0;
        setImage(new Image("/frogger/image/frog/froggerUp.png", size, size, true, true));
        isDeath = false;
        if (points > 50) {
          points -= 50;
          changeScore = true;
        }
      }
    }

    if (getX() > 600) {
      move(-movement * 2, 0);
    }
    if (getIntersectingObjects(Car.class).size() >= 1) {
      carDeath = true;
    }
    if (getX() == 240 && getY() == 82) {
      stop = true;
    }
    if (getIntersectingObjects(Log.class).size() >= 1 && !isDeath) {
      if (getIntersectingObjects(Log.class).get(0).getLeft()) move(-2, 0);
      else move(.75, 0);
    } else if (getIntersectingObjects(Turtle.class).size() >= 1 && !isDeath) {
      move(-1, 0);
    } else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
      if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
        waterDeath = true;
      } else {
        move(-1, 0);
      }
    } else if (getIntersectingObjects(End.class).size() >= 1) {
      inter = (ArrayList<End>) getIntersectingObjects(End.class);
      if (getIntersectingObjects(End.class).get(0).isActivated()) {
        end--;
        points -= 50;
      }
      points += 50;
      changeScore = true;
      w = 800;
      getIntersectingObjects(End.class).get(0).setEnd();
      end++;
      setX(300);
      setY(679.8 + movement);
    } else if (getY() < 413) {
      waterDeath = true;
      // setX(300);
      // setY(679.8+movement);
    }
  }
   */

  public boolean getStop() {
    return end == 5;
  }

  public int getPoints() {
    return points;
  }

  public boolean changeScore() {
    if (changeScore) {
      changeScore = false;
      return true;
    }
    return false;
  }

  @Override
  public void act(long now) {}
}
