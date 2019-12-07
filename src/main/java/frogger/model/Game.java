package frogger.model;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.controller.GameController;
import frogger.model.actor.End;
import frogger.util.WorldLoader;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class Game {

  private World world;

  private GameController gameController;
  private GameMode gameMode;
  private GameLevel gameLevel;

  public Game(GameController gameController, GameMode gameMode, GameLevel gameLevel, Pane root) {
    this.gameController = gameController;
    this.gameMode = gameMode;
    this.gameLevel = gameLevel;
    this.world = new World(new WorldLoader(gameMode, gameLevel, root));
    initGameScreen();
  }

  private void initGameScreen() {
    if (!isDoubleMode()) gameController.hidePlayerBInfo();
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

  private AnimationTimer timer =
      new AnimationTimer() {
        @Override
        public void handle(long now) {
          world.run(now);
          updateScore();
          updateLife();
          if (checkWin() || checkLose()) endGame();
        }
      };

  public void startGame() {
    timer.start();
  }

  private void endGame() {
    timer.stop();
  }

  private void updateScore() {
    int scoreA = world.getFrogA().getScore();
    int scoreB = isDoubleMode() ? world.getFrogB().getScore() : 0;
    gameController.updateScore(scoreA, scoreB);
  }

  private void updateLife() {
    int lifeA = world.getFrogA().getLife();
    int lifeB = isDoubleMode() ? world.getFrogB().getLife() : 0;
    gameController.updateLife(lifeA, lifeB);
  }

  private boolean checkWin() {
    if (!isDoubleMode()) {
      for (End end : world.getEnds()) {
        if (!end.isActivated()) return false;
      }
      return true;
    } else return false;
  }

  private boolean checkLose() {
    switch (gameMode) {
      case SINGLE:
        return world.getFrogA().getLife() == 0;
      case DOUBLE:
        return world.getFrogA().getLife() == 0 && world.getFrogB().getLife() == 0;
    }
    return false;
  }

  private boolean isDoubleMode() {
    return gameMode == GameMode.DOUBLE;
  }
}
