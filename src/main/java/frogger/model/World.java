package frogger.model;

import frogger.model.actor.AutomaticActor;
import frogger.model.actor.End;
import frogger.model.actor.Frog;
import frogger.util.TouchChecker;
import frogger.util.WorldLoader;

import java.util.ArrayList;

public class World {

  private Frog frogA;
  private Frog frogB;
  private ArrayList<AutomaticActor> automaticActors;
  private ArrayList<End> ends;

  public World(WorldLoader worldLoader) {
    frogA = worldLoader.getFrogA();
    frogB = worldLoader.getFrogB();
    automaticActors = worldLoader.getMovableActors();
    ends = worldLoader.getEnds();
  }

  public Frog getFrogA() {
    return frogA;
  }

  public Frog getFrogB() {
    return frogB;
  }

  public ArrayList<End> getEnds() {
    return ends;
  }

  public void run(long now) {
    for (AutomaticActor automaticActor : automaticActors) automaticActor.act(now);
    frogA.act(now);
    TouchChecker.INSTANCE.checkTouchActor(frogA, automaticActors, ends);
    if (frogB != null) {
      frogB.act(now);
      TouchChecker.INSTANCE.checkTouchActor(frogB, automaticActors, ends);
    }
  }
}
