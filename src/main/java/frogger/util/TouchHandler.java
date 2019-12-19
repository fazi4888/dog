package frogger.util;

import frogger.constant.Death;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.model.actor.*;

import java.util.ArrayList;

/**
 * The {@code TouchHandler} is a utility to handle the touch event about the frog.
 *
 * <p><b>Note:</b> this class is a singleton with {@link Enum}.
 */
public enum TouchHandler {
  INSTANCE;

  private GameMode gameMode;

  /** The list of ends which have been activated. */
  private ArrayList<End> activatedEnds = new ArrayList<>();

  /**
   * Initializes the TouchHandler.
   *
   * @param gameMode the model of the game
   * @see SceneSwitch#switchToGame(GameMode, GameLevel, String, String)
   */
  public void init(GameMode gameMode) {
    this.gameMode = gameMode;
    activatedEnds.clear();
  }

  /**
   * Handles event that the frog touches an end.
   *
   * @param frog the frog that controlled by the player
   * @param end the end which is touched by the frog
   */
  public void touchEnd(Frog frog, End end) {
    if (!end.isActivated()) {
      if (end.isFlyInThisEnd()) frog.touchFlyEnd();
      else frog.touchEnd();
      end.setFrog();
      activatedEnds.add(end);
      if (activatedEnds.size() == 5) touchAllEnd();
    }
  }

  /** If all ends have been activated and game mode is double, reset ends. */
  private void touchAllEnd() {
    if (gameMode == GameMode.DOUBLE) {
      activatedEnds.forEach(End::resetActor);
    }
  }

  /**
   * Handles event that the frog is off the screen.
   *
   * @param frog the frog that controlled by the player
   */
  public void overScreen(Frog frog) {
    frog.setDeath(Death.OVERSCREEN);
    frog.loseLife();
    frog.rebirth();
  }

  /**
   * Handles event that the frog touches a log.
   *
   * @param frog the frog that controlled by the player
   * @param log the log which is touched by the frog
   */
  public void touchLog(Frog frog, Log log) {
    frog.touchLogOrTurtle(log.getSpeed());
  }

  /**
   * Handles event that the frog touches a car.
   *
   * @param frog the frog that controlled by the player
   */
  public void touchCar(Frog frog) {
    frog.setDeath(Death.CAR);
  }

  /**
   * Handles event that the frog touches a turtle.
   *
   * @param frog the frog that controlled by the player
   * @param turtle the turtle which is touched by the frog
   */
  public void touchTurtle(Frog frog, Turtle turtle) {
    frog.touchLogOrTurtle(turtle.getSpeed());
  }

  /**
   * Handles event that the frog touches a wet turtle.
   *
   * @param frog the frog that controlled by the player
   * @param wetTurtle the wet turtle which is touched by the frog
   */
  public void touchWetTurtle(Frog frog, WetTurtle wetTurtle) {
    if (!wetTurtle.isSunk()) {
      frog.touchLogOrTurtle(wetTurtle.getSpeed());
    } else {
      touchWater(frog);
    }
  }

  /**
   * Handles event that the frog is in the water.
   *
   * @param frog the frog that controlled by the player
   */
  public void touchWater(Frog frog) {
    frog.setDeath(Death.WATER);
  }
}
