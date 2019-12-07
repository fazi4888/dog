package frogger.model.actor;

import frogger.constant.Death;
import frogger.constant.Direction;
import frogger.constant.FileName;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Frog extends Actor {

  private Image imgW;
  private Image imgA;
  private Image imgS;
  private Image imgD;
  private Image imgWJump;
  private Image imgAJump;
  private Image imgSJump;
  private Image imgDJump;

  private ArrayList<Image> carDeath;
  private ArrayList<Image> waterDeath;

  private int size = 50;
  private double movementY = 34;
  private double movementX = 20;

  private boolean isJumping;
  private boolean hasJump;
  private boolean noMove;
  private Death death;
  private int deathImgIndex = 0;

  private double higestY;
  private int score;
  private int life;
  private int touchedEndAmount;

  public Frog(String imageLink, int xpos, int ypos) {
    super(imageLink, xpos, ypos, 50, 50);
    initFrogStateImage();
    initDeathImage();
  }

  @Override
  public void resetActor() {
    higestY = 965;
    score = 0;
    life = 3;
    touchedEndAmount = 0;
    rebirth();
  }

  private void rebirth() {
    System.out.println("current life: " + life + "; current score " + score);
    super.resetActor();
    setDeath(Death.NONE);
    setImage(imgW);
    isJumping = false;
    noMove = life == 0;
    deathImgIndex = 0;
    hasJump = false;
  }

  public void setDeath(Death death) {
    this.death = death;
  }

  public Death getDeath() {
    return death;
  }

  public int getScore() {
    return score;
  }

  public int getLife() {
    return life;
  }

  public void gainScore(int value) {
    score += value;
    System.out.println("gain score: " + value + "; current score: " + score);
  }

  public void loseScore(int value) {
    score = Math.max(0, score - value);
  }

  public void loseLife() {
    loseScore(50);
    life--;
    if (life == 0) noMove = true;
  }

  public void jump(Direction direction, boolean isMoving) {
    if (!hasJump && !isMoving) return;
    if (noMove && !isJumping) return;
    switch (direction) {
      case UP:
        move(0, -movementY);
        setImage((isJumping) ? imgW : imgWJump);
        if (isMoving) checkValidForwardStep();
        break;
      case LEFT:
        move(-movementX, 0);
        setImage((isJumping) ? imgA : imgAJump);
        break;
      case DOWN:
        if (getY() + movementY < 980) {
          move(0, movementY);
          setImage((isJumping) ? imgS : imgSJump);
        }
        break;
      case RIGHT:
        move(movementX, 0);
        setImage((isJumping) ? imgD : imgDJump);
        break;
    }
    isJumping = (isMoving) ? !isJumping : false;
    if (isMoving) hasJump = true;
  }

  private void checkValidForwardStep() {
    if (getY() < higestY) {
      gainScore(20);
      higestY = getY();
    }
  }

  @Override
  public void act(long now) {
    if (getDeath() != Death.NONE) showDeathFrames(now, getDeath());
  }

  public void touchEnd() {
    gainScore(200);
    noMove = true;
    touchedEndAmount++;
    if (touchedEndAmount == 5) {
      gainScore(1000);
    }
    rebirth();
  }

  public void touchLogOrTurtle(double speed) {
    if (death != Death.NONE) return;
    move(speed, 0);
  }

  private void showDeathFrames(long now, Death death) {
    noMove = true;
    ArrayList<Image> currentDeathImg = (death == Death.CAR) ? carDeath : waterDeath;
    if (deathImgIndex >= 0 && deathImgIndex < currentDeathImg.size()) {
      setImage(currentDeathImg.get(deathImgIndex));
      if (now % 11 == 0) deathImgIndex++;
    } else {
      loseLife();
      rebirth();
    }
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

  private void initDeathImage() {
    carDeath =
        new ArrayList<>() {
          {
            add(new Image(FileName.IMAGE_DEATH_CAR_1, size, size, true, true));
            add(new Image(FileName.IMAGE_DEATH_CAR_2, size, size, true, true));
            add(new Image(FileName.IMAGE_DEATH_CAR_3, size, size, true, true));
          }
        };
    waterDeath =
        new ArrayList<>() {
          {
            add(new Image(FileName.IMAGE_DEATH_WATER_1, size, size, true, true));
            add(new Image(FileName.IMAGE_DEATH_WATER_2, size, size, true, true));
            add(new Image(FileName.IMAGE_DEATH_WATER_3, size, size, true, true));
            add(new Image(FileName.IMAGE_DEATH_WATER_4, size, size, true, true));
          }
        };
  }
}
