package frogger.controller;

import frogger.util.MusicPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameController {

  @FXML private Button musicon;
  @FXML private Button musicoff;

  @FXML private Text scoreTitleA;
  @FXML private Text scoreNumberA;
  @FXML private Text scoreTitleB;
  @FXML private Text scoreNumberB;

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

  public void hidePlayerBInfo() {
    scoreTitleB.setVisible(false);
    scoreNumberB.setVisible(false);
  }

  public void updateScore(boolean isPlayerA, int value) {
    if (isPlayerA) scoreNumberA.setText(String.format("%04d", value));
    else scoreNumberB.setText(String.format("%04d", value));
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
