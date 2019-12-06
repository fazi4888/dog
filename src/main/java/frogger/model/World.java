package frogger.model;

import frogger.model.actor.Actor;
import frogger.model.actor.AutomaticActor;
import frogger.model.actor.End;
import frogger.model.actor.Frog;
import frogger.util.TouchChecker;
import frogger.util.WorldLoader;

import java.util.ArrayList;

public class World {

  private Frog frogA;
  private Frog frogB;
  private ArrayList<AutomaticActor> movableActors;
  private ArrayList<End> ends;

  private ArrayList<Actor> allActors;
  private ArrayList<AutomaticActor> allAutoActors;

  public World(WorldLoader worldLoader) {
    frogA = worldLoader.getFrogA();
    frogB = worldLoader.getFrogB();
    movableActors = worldLoader.getMovableActors();
    ends = worldLoader.getEnds();
    initAllActors();
  }

  public Frog getFrogA() {
    return frogA;
  }

  public Frog getFrogB() {
    return frogB;
  }

  public void run(long now) {
    for (Actor actor : allActors) actor.act(now);
    TouchChecker.INSTANCE.checkTouchActor(frogA, allAutoActors);
    if (frogB != null) TouchChecker.INSTANCE.checkTouchActor(frogB, allAutoActors);
  }

  private void initAllActors() {
    allAutoActors =
        new ArrayList<>() {
          {
            addAll(ends);
            addAll(movableActors);
          }
        };
    allActors =
        new ArrayList<>() {
          {
            addAll(allAutoActors);
            add(frogA);
            if (frogB != null) add(frogB);
          }
        };
  }
}
