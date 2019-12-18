package frogger.controller;

import frogger.util.MusicPlayer;
import frogger.util.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;

/** The {@code GameController} is a controller for the game view. */
public class GameController {

  @FXML private Button musicon;
  @FXML private Button musicoff;

  @FXML private Text scoreTitleA;
  @FXML private Text scoreTitleB;

  /** The score of player A. */
  @FXML private Text scoreNumberA;

  /** The score of player B. */
  @FXML private Text scoreNumberB;

  /** The images shows the remaining life of player A. */
  @FXML private ArrayList<ImageView> lifesA;

  /** The images shows the remaining life of player B. */
  @FXML private ArrayList<ImageView> lifesB;

  /** The prompt about the game result. */
  @FXML private Label resultPrompt;

  /** The button back to home. */
  @FXML private Button backHome;

  /** Initializes the UI. */
  @FXML
  public void initialize() {
    updateMusicBtn();
    resultPrompt.setVisible(false);
    backHome.setVisible(false);
    backHome.setDisable(true);
  }

  /** Switches music state. */
  @FXML
  public void switchMusicState() {
    if (MusicPlayer.INSTANCE.isOn()) {
      MusicPlayer.INSTANCE.stopMusic();
    } else {
      MusicPlayer.INSTANCE.playMusic();
    }
    updateMusicBtn();
  }

  /** Switches scene to home. */
  @FXML
  public void backToHome() {
    SceneSwitch.INSTANCE.switchToHome();
  }

  /**
   * Updates the prompt of the game result.
   *
   * @param prompt the prompt of the game result
   */
  public void setResultPrompt(String prompt) {
    resultPrompt.setText(prompt);
    resultPrompt.setVisible(true);
  }

  /**
   * Called when game over.
   *
   * <p>Shows the button back to home.
   */
  public void updateBackBtn() {
    backHome.setVisible(true);
    backHome.setDisable(false);
  }

  /**
   * Called when the game mode is single.
   *
   * <p>Hides the information about player B.
   */
  public void hidePlayerBInfo() {
    scoreTitleB.setVisible(false);
    scoreNumberB.setVisible(false);
    for (ImageView life : lifesB) life.setVisible(false);
  }

  /**
   * Updates the score of players.
   *
   * @param scoreA the score of player A
   * @param scoreB the score of player B
   */
  public void updateScore(int scoreA, int scoreB) {
    scoreNumberA.setText(String.format("%04d", scoreA));
    scoreNumberB.setText(String.format("%04d", scoreB));
  }

  /**
   * Updates the life number of players.
   *
   * @param lifeA the remaining life of player A
   * @param lifeB the remaining life of player B
   */
  public void updateLife(int lifeA, int lifeB) {
    for (int i = 3; i > lifeA; i--) lifesA.get(i - 1).setVisible(false);
    for (int i = 3; i > lifeB; i--) lifesB.get(i - 1).setVisible(false);
  }

  /** Updates the music button. */
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
