package frogger.util;

import frogger.constant.Death;
import frogger.constant.GameMode;
import frogger.model.Game;
import frogger.model.actor.*;

import java.util.ArrayList;

public enum TouchHandler {
  INSTANCE;

  private Game game;
  private ArrayList<End> activatedEnds = new ArrayList<>();

  public void init(Game game) {
    this.game = game;
    activatedEnds.clear();
  }

  public void touchEnd(Frog frog, End end) {
    if (!end.isActivated()) {
      frog.touchEnd();
      end.setEnd();
      activatedEnds.add(end);
      if (activatedEnds.size() == 5) touchAllEnd();
    }
  }

  private void touchAllEnd() {
    if (game.getGameMode() == GameMode.DOUBLE) {
      activatedEnds.forEach(End::resetActor);
    }
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
