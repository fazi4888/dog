package frogger.util;

import frogger.model.actor.*;

public enum TouchHandler {
  INSTANCE;

  public void touchEnd(Frog frog, End end) {
    if (!end.isActivated()) {
      frog.touchEnd();
      end.setEnd();
    }
  }

  public void touchLog(Frog frog, Log log) {
    frog.touchLogOrTurtle(log.getSpeed());
  }

  public void touchCar(Frog frog) {
    frog.touchCar();
  }

  public void touchTurtle(Frog frog, Turtle turtle) {
    frog.touchLogOrTurtle(turtle.getSpeed());
  }

  public void touchWetTurtle(Frog frog, WetTurtle wetTurtle) {
    if (!wetTurtle.isSunk()) {
      frog.touchLogOrTurtle(wetTurtle.getSpeed());
    } else {
      frog.touchSunkTurtle();
    }
  }

  public void touchWater(Frog frog) {
    frog.touchWater();
  }
}
