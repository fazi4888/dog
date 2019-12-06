package frogger.model;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.constant.GameStatus;
import frogger.controller.GameController;
import frogger.util.WorldLoader;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class Game {

  private World world;

  private GameController gameController;
  private GameStatus gameStatus;
  private GameMode gameMode;
  private GameLevel gameLevel;

  public Game(GameController gameController, GameMode gameMode, GameLevel gameLevel, Pane root) {
    this.gameController = gameController;
    this.gameMode = gameMode;
    this.gameLevel = gameLevel;
    this.gameStatus = GameStatus.START;
    this.world = new World(new WorldLoader(gameMode, gameLevel, root));
    this.gameController.initController(this);
    startGame();
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

  public void startGame() {
    start();
  }

  public void endGame() {
    stop();
    gameStatus = GameStatus.END;
  }

  private AnimationTimer timer =
      new AnimationTimer() {
        @Override
        public void handle(long now) {
          world.run(now);
        }
      };

  private void start() {
    timer.start();
  }

  private void stop() {
    timer.stop();
  }
}
