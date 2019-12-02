package frogger.controller;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.model.World;
import frogger.util.MusicPlayer;
import frogger.util.SceneSwitch;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

  @FXML public Button musicon;;
  @FXML public Button musicoff;

  @FXML
  public void startGame() {
//    SceneSwitch.INSTANCE.switchToSelection();
    SceneSwitch.INSTANCE.switchToGame(GameMode.DOUBLE, GameLevel.EASY);
  }

  @FXML
  public void showScoreboard() {}

  @FXML
  public void exitGame() {
    Platform.exit();
  }

  @FXML
  public void switchMusicState() {
    if (MusicPlayer.INSTANCE.isOn()) {
      MusicPlayer.INSTANCE.stopMusic();
    } else {
      MusicPlayer.INSTANCE.playMusic();
    }
    updateMusicBtn();
  }

  public void updateMusicBtn() {
    if (MusicPlayer.INSTANCE.isOn()) {
      musicon.setStyle("-fx-opacity: 1");
      musicoff.setStyle("-fx-opacity: 0");
    } else {
      musicon.setStyle("-fx-opacity: 0");
      musicoff.setStyle("-fx-opacity: 1");
    }
  }
}
