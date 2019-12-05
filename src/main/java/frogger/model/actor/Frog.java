package frogger.model.actor;

import frogger.constant.Direction;
import frogger.constant.FileName;
import javafx.scene.image.Image;

public class Frog extends Actor {

  private Image imgW;
  private Image imgA;
  private Image imgS;
  private Image imgD;
  private Image imgWJump;
  private Image imgAJump;
  private Image imgSJump;
  private Image imgDJump;

  private int size = 50;
  private double movementY = 34;
  private double movementX = 20;
  private boolean isJumping = false;

  boolean isDeath = false;

  public Frog(String imageLink, int xpos) {
    super(imageLink, xpos, 965, 50, 50);
    initFrogStateImage();
  }

  @Override
  public void resetActor() {
    super.resetActor();
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
        move(0, -movementY);
        setImage((isJumping) ? imgW : imgWJump);
        break;
      case LEFT:
        move(-movementX, 0);
        setImage((isJumping) ? imgA : imgAJump);
        break;
      case DOWN:
        move(0, movementY);
        setImage((isJumping) ? imgS : imgSJump);
        break;
      case RIGHT:
        move(movementX, 0);
        setImage((isJumping) ? imgD : imgDJump);
        break;
    }
    isJumping = (isMoving) ? !isJumping : false;
  }

  public void touchWater() {}

  public void touchCar() {}

  public void touchLogOrTurtle() {}

  public void touchSunkTurtle() {}
}
