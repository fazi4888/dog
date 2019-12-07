package frogger.util;

import frogger.Main;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.controller.GameController;
import frogger.model.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public enum SceneSwitch {
  INSTANCE;

  private void changeScene(String fxmlFile) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
      Pane root = loader.load();
      Scene scene = new Scene(root);
      Main.getPrimaryStage().setScene(scene);
      Main.getPrimaryStage().show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void switchToHome() {
    changeScene("/frogger/view/home.fxml");
  }

  public void switchToSelection() {
//    changeScene("/frogger/view/selection.fxml");
  }

  public void switchToGame(GameMode gameMode, GameLevel gameLevel) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/frogger/view/game.fxml"));
      Pane root = loader.load();
      Scene scene = new Scene(root);
      Main.getPrimaryStage().setScene(scene);


      GameController gameController = loader.getController();
      Game game = new Game(gameController, gameMode, gameLevel, root);
      game.startGame();

      scene.addEventHandler(KeyEvent.KEY_PRESSED, game.getWorld()::keyPressed);
      scene.addEventHandler(KeyEvent.KEY_RELEASED, game.getWorld()::keyReleased);

      Main.getPrimaryStage().show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
