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
    automaticActors = worldLoader.getAutomaticActors();
    ends = worldLoader.getEnds();
  }

  public Frog getFrogA() {
    return frogA;
  }

  public Frog getFrogB() {
    return frogB;
  }

  public void resetAllEnds() {
    ends.forEach(End::resetActor);
  }

  public void run(long now) {
    ArrayList<AutomaticActor> allActors = automaticActors;
    automaticActors.addAll(ends);
    for (AutomaticActor autoActor : allActors) autoActor.act(now);
    TouchChecker.INSTANCE.checkTouchActor(frogA, allActors);
    if (frogB != null) TouchChecker.INSTANCE.checkTouchActor(frogB, allActors);
  }
}
