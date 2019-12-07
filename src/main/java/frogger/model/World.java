package frogger.model;

import frogger.constant.Direction;
import frogger.constant.Operation;
import frogger.model.actor.AutomaticActor;
import frogger.model.actor.End;
import frogger.model.actor.Frog;
import frogger.util.TouchChecker;
import frogger.util.WorldLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.Map;

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
    TouchChecker.INSTANCE.touchActor(frogA, automaticActors, ends);
    if (frogB != null) {
      frogB.act(now);
      TouchChecker.INSTANCE.touchActor(frogB, automaticActors, ends);
    }
  }

  public void keyPressed(KeyEvent event) {
    System.out.println("KeyPressed " + event.getCode());
    judgeFrogJump(event, true);
  }

  public void keyReleased(KeyEvent event) {
    System.out.println("KeyReleased " + event.getCode());
    judgeFrogJump(event, false);
  }

  private void judgeFrogJump(KeyEvent event, boolean isMoving) {
    if (frogA != null) judgeJumpDirection(frogA, isMoving, Operation.DIRECTION_A, event.getCode());
    if (frogB != null) judgeJumpDirection(frogB, isMoving, Operation.DIRECTION_B, event.getCode());
  }

  private void judgeJumpDirection(Frog frog, boolean isMoving, Map<KeyCode, Direction> directions, KeyCode code) {
    if (!directions.containsKey(code)) return;
    frog.jump(directions.get(code), isMoving);
  }
}
