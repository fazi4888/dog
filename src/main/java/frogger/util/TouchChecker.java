package frogger.util;

import frogger.constant.Death;
import frogger.model.actor.*;
import javafx.geometry.Bounds;

import java.util.ArrayList;

/**
 * The {@code TouchChecker} is a utility to handle the touch event about the frog.
 *
 * <p><b>Note:</b> this class is a singleton with {@link Enum}.
 */
public enum TouchChecker {
  INSTANCE;

  /**
   * Checks if touch event happens.
   *
   * @param frog the frog that controlled by the player
   * @param automaticActors the automatic actors which could be touched by the frog
   * @param ends the ends which could be activated by the frog
   * @see frogger.model.World #run
   */
  public void touchActor(Frog frog, ArrayList<AutomaticActor> automaticActors, ArrayList<End> ends) {
    if (frog.getDeath() != Death.NONE) return;
    overScreen(frog);
    touchEnd(frog, ends);
    touchAutoActor(frog, automaticActors);
  }

  /**
   * Checks if the frog is off the screen.
   *
   * @param frog the frog that controlled by the player
   */
  private void overScreen(Frog frog) {
    if (frog.getX() < -30 || frog.getX() > 590) TouchHandler.INSTANCE.overScreen(frog);
  }

  /**
   * Checks if the frog touches the end.
   *
   * @param frog the frog that controlled by the player
   * @param ends the ends which could be activated by the frog
   */
  private void touchEnd(Frog frog, ArrayList<End> ends) {
    Bounds frogBounds = frog.localToScene(frog.getBoundsInLocal());
    for (End end : ends) {
      Bounds endBounds = end.localToScene(end.getBoundsInLocal());
      if (frogBounds.intersects(endBounds)) TouchHandler.INSTANCE.touchEnd(frog, end);
    }
  }

  /**
   * Checks if the frog touches any automatic actors.
   *
   * @param frog the frog that controlled by the player
   * @param automaticActors the automatic actors which could be touched by the frog
   */
  private void touchAutoActor(Frog frog, ArrayList<AutomaticActor> automaticActors) {
    Bounds frogBounds = frog.localToScene(frog.getBoundsInLocal());
    boolean isTouchActor = false;
    for (AutomaticActor automaticActor : automaticActors) {
      Bounds actorBounds = automaticActor.localToScene(automaticActor.getBoundsInLocal());
      if (frogBounds.intersects(actorBounds)) {
        isTouchActor = true;
        if (automaticActor instanceof Log) {
          TouchHandler.INSTANCE.touchLog(frog, (Log) automaticActor);
        } else if (automaticActor instanceof Turtle) {
          TouchHandler.INSTANCE.touchTurtle(frog, (Turtle) automaticActor);
        } else if (automaticActor instanceof WetTurtle) {
          TouchHandler.INSTANCE.touchWetTurtle(frog, (WetTurtle) automaticActor);
        } else if (automaticActor instanceof Car) {
          TouchHandler.INSTANCE.touchCar(frog);
        }
      }
    }
    // If the frog doesn't touch anything, check to see if it falls into the water
    if (!isTouchActor && touchWater(frog)) {
      TouchHandler.INSTANCE.touchWater(frog);
    }
  }

  /**
   * Check if the frog is in the water.
   *
   * @param frog the frog that controlled by the player
   * @return {@code true} if the frog is in the water; {@code false} otherwise
   */
  private boolean touchWater(Frog frog) {
    return frog.getY() < 380;
  }
}
