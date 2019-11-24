package frogger.controller;

import frogger.util.MusicPlayer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

  @FXML public Button musicon;
  @FXML public Button musicoff;

  @FXML
  public void startGame() {

  }

  @FXML
  public void showScoreboard() {

  }

  @FXML
  public void exitGame() {
    Platform.exit();
  }

  @FXML
  public void switchMusicState() {
    if (MusicPlayer.getInstance().isOn()) {
      MusicPlayer.getInstance().stopMusic();
      musicon.setStyle("-fx-opacity: 0");
      musicoff.setStyle("-fx-opacity: 1");
    } else {
      MusicPlayer.getInstance().playMusic();
      musicon.setStyle("-fx-opacity: 1");
      musicoff.setStyle("-fx-opacity: 0");
    }
  }

}
