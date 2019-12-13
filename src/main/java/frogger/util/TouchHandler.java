package frogger.util;

import frogger.constant.Death;
import frogger.constant.GameMode;
import frogger.model.actor.*;

import java.util.ArrayList;

public enum TouchHandler {
  INSTANCE;

  private GameMode gameMode;
  private ArrayList<End> activatedEnds = new ArrayList<>();

  public void init(GameMode gameMode) {
    this.gameMode = gameMode;
    activatedEnds.clear();
  }

  public void touchEnd(Frog frog, End end) {
    if (!end.isActivated()) {
      if (end.isFlyInThisEnd()) frog.touchFlyEnd();
      else frog.touchEnd();
      end.setFrog();
      activatedEnds.add(end);
      if (activatedEnds.size() == 5) touchAllEnd();
    }
  }

  private void touchAllEnd() {
    if (gameMode == GameMode.DOUBLE) {
      activatedEnds.forEach(End::resetActor);
    }
  }

  public void overScreen(Frog frog) {
    frog.setDeath(Death.OVERSCREEN);
    frog.loseLife();
    frog.rebirth();
  }

  public void touchLog(Frog frog, Log log) {
    frog.touchLogOrTurtle(log.getSpeed());
  }

  public void touchCar(Frog frog) {
    frog.setDeath(Death.CAR);
  }

  public void touchTurtle(Frog frog, Turtle turtle) {
    frog.touchLogOrTurtle(turtle.getSpeed());
  }

  public void touchWetTurtle(Frog frog, WetTurtle wetTurtle) {
    if (!wetTurtle.isSunk()) {
      frog.touchLogOrTurtle(wetTurtle.getSpeed());
    } else {
      touchWater(frog);
    }
  }

  public void touchWater(Frog frog) {
    frog.setDeath(Death.WATER);
  }
}
