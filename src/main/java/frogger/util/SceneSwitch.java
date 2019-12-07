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
    changeScene("/frogger/view/home.fxml");
  }

  public void switchToSelection() {
    changeScene("/frogger/view/selection.fxml");
  }

  public void switchToGame(GameMode gameMode, GameLevel gameLevel) {
    changeScene("/frogger/view/game.fxml");

    GameController gameController = loader.getController();
    Game game = new Game(gameController, gameMode, gameLevel, root);
    game.startGame();

    scene.addEventHandler(KeyEvent.KEY_PRESSED, game.getWorld()::keyPressed);
    scene.addEventHandler(KeyEvent.KEY_RELEASED, game.getWorld()::keyReleased);
  }
}
