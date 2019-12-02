package frogger.model;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.constant.GameStatus;
import javafx.scene.layout.Pane;

public enum Game {
  INSTANCE;

  private World world;

  private GameStatus gameStatus;

  private GameMode gameMode;

  private GameLevel gameLevel;

  private Player playerA;

  private Player playerB;

  public void init(GameMode gameMode, GameLevel gameLevel, Pane root) {
    this.gameMode = gameMode;
    this.gameLevel = gameLevel;
    this.gameStatus = GameStatus.START;
    this.world = new World(gameMode);
    world.init(root);
  }

  public GameStatus getGameStatus() {
    return gameStatus;
  }

  public GameMode getGameMode() {
    return gameMode;
  }

  public GameLevel getGameLevel() {
    return gameLevel;
  }

  public World getWorld() {
    return world;
  }
}
