package frogger.controller;

import frogger.util.MusicPlayer;
import frogger.util.SceneSwitch;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/** The {@code HomeController} is a controller for the home view. */
public class HomeController {

  @FXML private Button musicon;;
  @FXML private Button musicoff;

  /** Initializes the UI. */
  @FXML
  public void initialize() {
    updateMusicBtn();
  }

  /** Switches the scene to selection. */
  @FXML
  public void startGame() {
    SceneSwitch.INSTANCE.switchToSelection();
  }

  /** Shows the help of the game. */
  @FXML
  public void showHelp() {
    SceneSwitch.INSTANCE.showHelp();
  }

  /** Exits the game. */
  @FXML
  public void exitGame() {
    Platform.exit();
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
