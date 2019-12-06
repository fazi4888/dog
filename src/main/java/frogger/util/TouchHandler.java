package frogger.util;

import frogger.model.actor.*;

import java.util.ArrayList;

public enum TouchHandler {
  INSTANCE;

  private ArrayList<End> activatedEnds = new ArrayList<>();

  public void touchEnd(Frog frog, End end) {
    if (!end.isActivated()) {
      frog.touchEnd();
      end.setEnd();
      activatedEnds.add(end);
    }
  }

  public void touchAllEnd(Frog frog) {
    activatedEnds.forEach(End::resetActor);
    activatedEnds.clear();
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
      frog.touchWater();
    }
  }

  public void touchWater(Frog frog) {
    frog.touchWater();
  }
}
