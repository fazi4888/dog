package frogger.util;

import frogger.model.actor.*;
import javafx.geometry.Bounds;

import java.util.ArrayList;

public enum TouchChecker {
  INSTANCE;

  public void checkTouchActor(Frog frog, ArrayList<AutomaticActor> automaticActors) {
    boolean isTouchActor = false;
    Bounds frogBounds = frog.localToScene(frog.getBoundsInLocal());
    for (AutomaticActor automaticActor : automaticActors) {
      Bounds actorBounds = automaticActor.localToScene(automaticActor.getBoundsInLocal());
      if (frogBounds.intersects(actorBounds)) {
        isTouchActor = true;
        if (automaticActor instanceof End) {
          TouchHandler.INSTANCE.touchEnd(frog, (End) automaticActor);
        } else if (automaticActor instanceof Log) {
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
    if (!isTouchActor && checkTouchWater(frog)) {
      TouchHandler.INSTANCE.touchWater(frog);
    }
  }

  private boolean checkTouchWater(Frog frog) {
    return frog.getY() < 530;
  }
}
