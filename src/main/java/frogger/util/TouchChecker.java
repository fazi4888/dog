package frogger.util;

import frogger.constant.Death;
import frogger.model.actor.*;
import javafx.geometry.Bounds;

import java.util.ArrayList;

public enum TouchChecker {
  INSTANCE;

  public void touchActor(Frog frog, ArrayList<AutomaticActor> automaticActors, ArrayList<End> ends) {
    if (frog.getDeath() != Death.NONE) return;
    touchEnd(frog, ends);
    touchAutoActor(frog, automaticActors);
  }

  private void touchEnd(Frog frog, ArrayList<End> ends) {
    Bounds frogBounds = frog.localToScene(frog.getBoundsInLocal());
    for (End end : ends) {
      Bounds endBounds = end.localToScene(end.getBoundsInLocal());
      if (frogBounds.intersects(endBounds)) TouchHandler.INSTANCE.touchEnd(frog, end);
    }
  }

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
    if (!isTouchActor && touchWater(frog)) {
      TouchHandler.INSTANCE.touchWater(frog);
    }
  }

  private boolean touchWater(Frog frog) {
    return frog.getY() < 520;
  }
}
