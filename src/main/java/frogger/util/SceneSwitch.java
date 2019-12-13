package frogger.util;

import frogger.Main;
import frogger.constant.FileName;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.controller.GameController;
import frogger.controller.ScoreboardController;
import frogger.controller.SelectionController;
import frogger.model.Game;
import frogger.model.actor.Frog;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The {@code SceneSwitch} class is a utility to switch different scenes ({@link #switchToHome()},
 * {@link #switchToSelection()} and {@link #switchToGame(GameMode, GameLevel, String, String)}) in
 * the primary stage or create a new stage ({@link #showHelp()} and {@link
 * #showScoreboard(String)}).
 *
 * <p><b>Note:</b> this class is a singleton with {@link Enum}.
 */
public enum SceneSwitch {
  INSTANCE;

  /** The FXMLLoader of corresponding FXML file. */
  private FXMLLoader loader;
  /** The loaded pane from the FXML file. */
  private Pane root;
  /** The scene for the root Node. */
  private Scene scene;

  /** The jumping frog on the home & selection page. */
  private Frog frog;

  /**
   * Changes the scene of the primary stage according to the given fxml file.
   *
   * @param fxmlFile the path of the fxml file
   */
  private void changeScene(String fxmlFile) {
    try {
      this.loader = new FXMLLoader(getClass().getResource(fxmlFile));
      this.root = loader.load();
      this.scene = new Scene(root);
      Main.getPrimaryStage().setScene(scene);
      Main.getPrimaryStage().show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /** Switches the current scene to home page. */
  public void switchToHome() {
    changeScene(FileName.VIEW_HOME);

    // add a jumping frog on the screen
    HomeAnimation homeAnimation = new HomeAnimation();
    this.frog = homeAnimation.getFrog();
    root.getChildren().add(frog);
    homeAnimation.start();
  }

  /** Switches the current scene to selection page. */
  public void switchToSelection() {
    changeScene(FileName.VIEW_SELECTION);

    // add a jumping frog on the screen
    root.getChildren().add(frog);
  }

  /**
   * Switches the current scene to the game.
   *
   * @param gameMode the game mode chosen by the user
   * @param gameLevel the game level chosen by the user
   * @param nicknameA the nickname of player A
   * @param nicknameB the nickname of player B
   * @see SelectionController#startGame()
   */
  public void switchToGame(
      GameMode gameMode, GameLevel gameLevel, String nicknameA, String nicknameB) {
    changeScene(FileName.VIEW_GAME);

    // initialize the game
    GameController gameController = loader.getController();
    Game game = new Game(gameController, gameMode, gameLevel, root);
    game.setPlayerName(nicknameA, nicknameB);
    TouchHandler.INSTANCE.init(gameMode);
    game.startGame();

    // add event handler for keyboard event
    scene.addEventHandler(KeyEvent.KEY_PRESSED, game.getWorld()::keyPressed);
    scene.addEventHandler(KeyEvent.KEY_RELEASED, game.getWorld()::keyReleased);
  }

  /** Creates a new stage to show the help page. */
  public void showHelp() {
    try {
      FXMLLoader loader = new FXMLLoader((getClass().getResource(FileName.VIEW_HELP)));
      Pane root = loader.load();
      Stage helpStage = new Stage();
      helpStage.setScene(new Scene(root));
      helpStage.initOwner(Main.getPrimaryStage().getScene().getWindow());
      helpStage.setResizable(false);
      helpStage.setTitle("HELP");
      helpStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates a new stage to show the scoreboard.
   *
   * @param gameLevel the game level of current game
   */
  public void showScoreboard(String gameLevel) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(FileName.VIEW_SCOREBOARD));
      Pane root = loader.load();
      Stage scoreboardStage = new Stage();
      scoreboardStage.setScene(new Scene(root));
      scoreboardStage.initOwner(Main.getPrimaryStage().getScene().getWindow());
      scoreboardStage.setResizable(false);
      scoreboardStage.setTitle("SCOREBOARD");

      ScoreboardController scoreboardController = loader.getController();
      scoreboardController.setGameLevel(gameLevel);
      scoreboardController.init();
      scoreboardStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
