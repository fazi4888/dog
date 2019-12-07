package frogger.controller;

import frogger.util.MusicPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {

  @FXML public Button musicon;
  @FXML public Button musicoff;

  @FXML
  public void initialize() {
    updateMusicBtn();
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

  private void updateMusicBtn() {
    if (MusicPlayer.INSTANCE.isOn()) {
      musicon.setStyle("-fx-opacity: 1");
      musicoff.setStyle("-fx-opacity: 0");
    } else {
      musicon.setStyle("-fx-opacity: 0");
      musicoff.setStyle("-fx-opacity: 1");
    }
  }
}
