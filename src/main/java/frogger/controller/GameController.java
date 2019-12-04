package frogger.controller;

import frogger.constant.Direction;
import frogger.constant.Operation;
import frogger.model.Frog;
import frogger.model.Game;
import frogger.model.World;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Map;

public class GameController {

  private Game game;
  private World world;
  private Frog frogA;
  private Frog frogB;

  public void initController(Game game) {
    this.game = game;
    this.world = game.getWorld();
    this.frogA = world.getFrogA();
    this.frogB = world.getFrogB();
  }

  public void keyPressed(KeyEvent event) {
    judgeFrogJump(event, true);
  }

  public void keyReleased(KeyEvent event) {
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
