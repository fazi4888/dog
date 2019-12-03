package frogger.model;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.constant.GameStatus;

public class Game {

  private World world;

  private GameStatus gameStatus;

  private GameMode gameMode;

  private GameLevel gameLevel;

  private Player playerA;

  private Player playerB;

  public void init(GameMode gameMode, GameLevel gameLevel, World world) {
    this.gameMode = gameMode;
    this.gameLevel = gameLevel;
    this.gameStatus = GameStatus.START;
    this.world = world;
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
