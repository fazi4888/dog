package frogger.model;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.controller.GameController;
import frogger.model.actor.End;
import frogger.util.SceneSwitch;
import frogger.util.ScoreboardWriter;
import frogger.util.WorldLoader;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

/**
 * A {@code Game} will be created when the player starts a new game.
 *
 * @see SceneSwitch#switchToGame(GameMode, GameLevel, String nicknameA, String nicknameB)
 */
public class Game {

  /** The {@link World} of the game. */
  private World world;
  /** The {@link GameController} of the game view. */
  private GameController gameController;
  /** The {@link GameMode} of the game. */
  private GameMode gameMode;
  /** The {@link GameLevel} of the game. */
  private GameLevel gameLevel;

  /**
   * Constructs a new {@code Game} with the specified parameters and creates a new {@link World} of
   * the game.
   *
   * @param gameController the {@link GameController} of the game view
   * @param gameMode the {@link GameMode} of the game
   * @param gameLevel the {@link GameLevel} of the game
   * @param root the {@link Pane} that is expected to be drawn
   */
  public Game(GameController gameController, GameMode gameMode, GameLevel gameLevel, Pane root) {
    this.gameController = gameController;
    this.gameMode = gameMode;
    this.gameLevel = gameLevel;
    this.world = new World(new WorldLoader(gameMode, gameLevel, root));
    initGameScreen();
  }

  /** Hides the information of player B if the game mode is single. */
  private void initGameScreen() {
    if (!isDoubleMode()) gameController.hidePlayerBInfo();
  }

  public World getWorld() {
    return world;
  }

  /**
   * Sets the nickname of players.
   *
   * @param nicknameA the nickname of the player A
   * @param nicknameB the nickname of the player B
   * @see SceneSwitch#switchToGame(GameMode, GameLevel, String, String)
   */
  public void setPlayerName(String nicknameA, String nicknameB) {
    if (!nicknameA.equals("")) world.getFrogA().setNickname(nicknameA);
    if (isDoubleMode() && !nicknameB.equals("")) world.getFrogB().setNickname(nicknameB);
  }

  /**
   * AnimationTimer for the game.
   *
   * <p>It will update the score and life of players and check if game is over.
   */
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

  /** Starts the game. */
  public void startGame() {
    timer.start();
  }

  /**
   * Ends the game and updates the prompt on the screen. If the game mode is {@code DOUBLE}, a
   * scoreboard will be popped up.
   *
   * @see #generatePrompt()
   * @see SceneSwitch#showScoreboard(String)
   */
  private void endGame() {
    timer.stop();
    if (!isDoubleMode()) {
      recordScore();
      SceneSwitch.INSTANCE.showScoreboard(gameLevel.name());
    }
    gameController.setResultPrompt(generatePrompt());
    gameController.updateBackBtn();
  }

  /**
   * Write the player's info to the scoreboard file.
   *
   * @see ScoreboardWriter
   */
  private void recordScore() {
    String nickname = getWorld().getFrogA().getNickname();
    String score = String.format("%04d", getWorld().getFrogA().getScore());
    ScoreboardWriter scoreboardWriter =
        new ScoreboardWriter(gameLevel.name().toLowerCase() + ".txt");
    scoreboardWriter.write(nickname + ";" + score + "\n");
  }

  /**
   * Generates the prompt according to the game mode and the score of two players.
   *
   * @return the prompt be generated
   */
  private String generatePrompt() {
    String prompt;
    if (!isDoubleMode()) {
      prompt = "Game Over";
    } else {
      int scoreA = world.getFrogA().getScore();
      int scoreB = world.getFrogB().getScore();
      if (scoreA == scoreB) {
        prompt = "You're Tie!!";
      } else {
        String frogAName = world.getFrogA().getNickname();
        String frogBName = world.getFrogB().getNickname();
        if (scoreA > scoreB) prompt = frogAName + " BEATS " + frogBName + "!!";
        else prompt = frogBName + " BEATS " + frogAName + "!!";
      }
    }
    return prompt;
  }

  /**
   * Updates the score of players.
   *
   * @see GameController#updateScore(int, int)
   */
  private void updateScore() {
    int scoreA = world.getFrogA().getScore();
    int scoreB = isDoubleMode() ? world.getFrogB().getScore() : 0;
    gameController.updateScore(scoreA, scoreB);
  }

  /**
   * Updates the life of players.
   *
   * @see GameController#updateLife(int, int)
   */
  private void updateLife() {
    int lifeA = world.getFrogA().getLife();
    int lifeB = isDoubleMode() ? world.getFrogB().getLife() : 0;
    gameController.updateLife(lifeA, lifeB);
  }

  /**
   * Check if the player is win
   *
   * @return {@code true} if in single mode, the frog touches all ends, {@code false} otherwise
   */
  private boolean checkWin() {
    if (!isDoubleMode()) {
      for (End end : world.getEnds()) {
        if (!end.isActivated()) return false;
      }
      return true;
    } else return false;
  }

  /**
   * Check if the player has lose all life.
   *
   * @return {@code true} if all players lose all life, {@code false} otherwise
   */
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
