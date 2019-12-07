package frogger.controller;

import frogger.util.MusicPlayer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class GameController {

  @FXML private Button musicon;
  @FXML private Button musicoff;

  @FXML private Text scoreTitleA;
  @FXML private Text scoreNumberA;
  @FXML private Text scoreTitleB;
  @FXML private Text scoreNumberB;

  @FXML private ArrayList<ImageView> lifesA;
  @FXML private ArrayList<ImageView> lifesB;

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
    for (ImageView life : lifesB) life.setVisible(false);
  }

  public void updateScore(int scoreA, int scoreB) {
    scoreNumberA.setText(String.format("%04d", scoreA));
    scoreNumberB.setText(String.format("%04d", scoreB));
  }

  public void updateLife(int lifeA, int lifeB) {
    for (int i = 3; i > lifeA; i--) lifesA.get(i - 1).setVisible(false);
    for (int i = 3; i > lifeB; i--) lifesB.get(i - 1).setVisible(false);
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
