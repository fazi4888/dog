package frogger.util;

import frogger.Main;
import frogger.constant.FileName;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.controller.GameController;
import frogger.controller.ScoreboardController;
import frogger.model.Game;
import frogger.model.actor.Frog;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public enum SceneSwitch {
  INSTANCE;

  private FXMLLoader loader;
  private Pane root;
  private Scene scene;

  private Frog frog;

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

  public void switchToHome() {
    changeScene(FileName.VIEW_HOME);

    HomeAnimation homeAnimation = new HomeAnimation();
    this.frog = homeAnimation.getFrog();
    root.getChildren().add(frog);
    homeAnimation.start();
  }

  public void switchToSelection() {
    changeScene(FileName.VIEW_SELECTION);
    root.getChildren().add(frog);
  }

  public void switchToGame(GameMode gameMode, GameLevel gameLevel, String nicknameA, String nicknameB) {
    changeScene(FileName.VIEW_GAME);

    GameController gameController = loader.getController();
    Game game = new Game(gameController, gameMode, gameLevel, root);
    game.setPlayerName(nicknameA, nicknameB);
    TouchHandler.INSTANCE.init(gameMode);
    game.startGame();

    scene.addEventHandler(KeyEvent.KEY_PRESSED, game.getWorld()::keyPressed);
    scene.addEventHandler(KeyEvent.KEY_RELEASED, game.getWorld()::keyReleased);
  }

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
