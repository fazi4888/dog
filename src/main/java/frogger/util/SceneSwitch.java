package frogger.util;

import frogger.Main;
import frogger.constant.FileName;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.controller.GameController;
import frogger.model.Game;
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
    root.getChildren().add(homeAnimation.getFrog());
    homeAnimation.start();
  }

  public void switchToSelection() {
    changeScene(FileName.VIEW_SELECTION);
  }

  public void switchToGame(GameMode gameMode, GameLevel gameLevel) {
    changeScene(FileName.VIEW_GAME);

    GameController gameController = loader.getController();
    Game game = new Game(gameController, gameMode, gameLevel, root);
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
      helpStage.setTitle("HELP");
      helpStage.setResizable(false);
      helpStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showScoreboard() {}
}
