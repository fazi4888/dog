package frogger.model.actor;

import frogger.constant.Death;
import frogger.constant.Direction;
import frogger.constant.FileName;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

/** A {@code Frog} is an object which is controlled by a player. */
public class Frog extends Actor {

  private ArrayList<Image> moveImg;
  private ArrayList<Image> moveImgJump;
  private ArrayList<Image> carDeath;
  private ArrayList<Image> waterDeath;

  private int size = 40;
  private double movementY = 25.4;
  private double movementX = 20;

  /** If the frog is jumping. */
  private boolean isJumping;
  /** If the frog has moved after rebirth. */
  private boolean hasJump;
  /** If the frog can move. */
  private boolean noMove;

  /** The type of the death. It will be NONE if the frog is alive. */
  private Death death;
  /** The index of the death frame image. */
  private int deathImgIndex = 0;

  /** The highest value in y coordinate of the frog ever reached. */
  private double highestY;
  /** The score of the player who controls the frog. */
  private int score;
  /** The life of the player who controls the frog. */
  private int life;
  /** The number of the ends which are activated by the frog. */
  private int touchedEndAmount;
  /** The nickname of the player who controls the frog. */
  private String nickname;

  public Frog(String imageLink, int xpos, int ypos) {
    super(imageLink, xpos, ypos, 40, 40);
    initStateImages();
  }

  @Override
  public void resetActor() {
    score = 0;
    life = 3;
    touchedEndAmount = 0;
    rebirth();
  }

  public void rebirth() {
    System.out.println("current life: " + life + "; current score " + score);
    super.resetActor();
    setDeath(Death.NONE);
    setImage(moveImg.get(0));
    isJumping = false;
    noMove = life == 0;
    deathImgIndex = 0;
    hasJump = false;
    highestY = 965;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getNickname() {
    return nickname;
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
    loseScore(100);
    life--;
    if (life == 0) noMove = true;
  }

  /**
   * Makes the frog jump in a certain direction.
   *
   * @param direction the direction to jump
   * @param isMoving if the frog is moving
   * @see frogger.model.World#keyPressed(KeyEvent)
   * @see frogger.model.World#keyReleased(KeyEvent)
   */
  public void jump(Direction direction, boolean isMoving) {
    if (!hasJump && !isMoving) return;
    if (noMove && !isJumping) return;
    switch (direction) {
      case UP:
        move(0, -movementY);
        setImage((isJumping) ? moveImg.get(0) : moveImgJump.get(0));
        if (isMoving) checkValidForwardStep();
        break;
      case LEFT:
        move(-movementX, 0);
        setImage((isJumping) ? moveImg.get(1) : moveImgJump.get(1));
        break;
      case DOWN:
        if (getY() + movementY < 745) {
          move(0, movementY);
          setImage((isJumping) ? moveImg.get(2) : moveImgJump.get(2));
        }
        break;
      case RIGHT:
        move(movementX, 0);
        setImage((isJumping) ? moveImg.get(3) : moveImgJump.get(3));
        break;
    }
    isJumping = (isMoving) ? !isJumping : false;
    if (isMoving) hasJump = true;
  }

  /**
   * Called when the frog move forward.
   *
   * <p>If the move is valid. The player who controls the frog will gain 20 pt.
   */
  private void checkValidForwardStep() {
    if (getY() < highestY) {
      gainScore(20);
      highestY = getY();
    }
  }

  /**
   * If the frog falls into the water or be a roadkill, show the death frame.
   *
   * @param now the timestamp of the current frame given in nanoseconds
   */
  @Override
  public void act(long now) {
    if (death == Death.CAR || death == Death.WATER) showDeathFrames(now, getDeath());
  }

  /**
   * Shows the death frames.
   *
   * @param now the timestamp of the current frame given in nanoseconds
   * @param death the type of the death
   */
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

  /**
   * Called whe the frog touch an end with a fly.
   *
   * <p>The player who controls the frog will gain extra 200 pt.
   */
  public void touchFlyEnd() {
    gainScore(200);
    touchEnd();
  }

  /**
   * Called when the frog touch an end.
   *
   * <p>The player represented by the frog will gain 200 pt.
   */
  public void touchEnd() {
    gainScore(200);
    noMove = true;
    touchedEndAmount++;
    if (touchedEndAmount == 5) {
      gainScore(1000);
    }
    rebirth();
  }

  /**
   * Called when the frog touch a log or turtle.
   *
   * <p>The frog will move according to the speed of the log or turtle.
   *
   * @param speed the speed of the log or turtle.
   * @see frogger.util.TouchHandler
   */
  public void touchLogOrTurtle(double speed) {
    if (death != Death.NONE) return;
    move(speed, 0);
  }

  private void initStateImages() {
    moveImg =
        new ArrayList<>() {
          {
            add(new Image(FileName.IMAGE_FROG_PREFIX + "Up.png", size, size, true, true));
            add(new Image(FileName.IMAGE_FROG_PREFIX + "Left.png", size, size, true, true));
            add(new Image(FileName.IMAGE_FROG_PREFIX + "Down.png", size, size, true, true));
            add(new Image(FileName.IMAGE_FROG_PREFIX + "Right.png", size, size, true, true));
          }
        };
    moveImgJump =
        new ArrayList<>() {
          {
            add(new Image(FileName.IMAGE_FROG_PREFIX + "UpJump.png", size, size, true, true));
            add(new Image(FileName.IMAGE_FROG_PREFIX + "LeftJump.png", size, size, true, true));
            add(new Image(FileName.IMAGE_FROG_PREFIX + "DownJump.png", size, size, true, true));
            add(new Image(FileName.IMAGE_FROG_PREFIX + "RightJump.png", size, size, true, true));
          }
        };
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
