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

/**
 * The {@code World} is an object consisting of different actors.
 *
 * @see Game
 */
public class World {

  private Frog frogA;
  private Frog frogB;
  private ArrayList<AutomaticActor> automaticActors;
  private ArrayList<End> ends;

  /**
   * Constructs a new World by a WorldLoader.
   *
   * @param worldLoader the loader of the world
   * @see WorldLoader
   */
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
    for (End end : ends) end.act(now);
    frogA.act(now);
    TouchChecker.INSTANCE.touchActor(frogA, automaticActors, ends);
    if (frogB != null) {
      frogB.act(now);
      TouchChecker.INSTANCE.touchActor(frogB, automaticActors, ends);
    }
  }

  /**
   * Handler of key pressed event.
   *
   * @param event key pressed event
   * @see #judgeFrogJump(KeyEvent, boolean)
   */
  public void keyPressed(KeyEvent event) {
    judgeFrogJump(event, true);
  }

  /**
   * Handler of key released event.
   *
   * @param event key released event.
   * @see #judgeFrogJump(KeyEvent, boolean)
   */
  public void keyReleased(KeyEvent event) {
    judgeFrogJump(event, false);
  }

  private void judgeFrogJump(KeyEvent event, boolean isMoving) {
    if (frogA != null) judgeJumpDirection(frogA, isMoving, Operation.DIRECTION_A, event.getCode());
    if (frogB != null) judgeJumpDirection(frogB, isMoving, Operation.DIRECTION_B, event.getCode());
  }

  private void judgeJumpDirection(
      Frog frog, boolean isMoving, Map<KeyCode, Direction> directions, KeyCode code) {
    if (!directions.containsKey(code)) return;
    frog.jump(directions.get(code), isMoving);
  }
}
