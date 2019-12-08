package frogger.controller;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.util.MusicPlayer;
import frogger.util.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SelectionController {

  @FXML private Button mode;
  @FXML private Button level;

  @FXML private Button musicon;;
  @FXML private Button musicoff;

  @FXML
  public void initialize() {
    updateMusicBtn();
    mode.setUserData(GameMode.SINGLE);
    level.setUserData(GameLevel.EASY);
  }

  @FXML
  public void switchMode() {
    if (mode.getUserData() == GameMode.SINGLE) {
      mode.setUserData(GameMode.DOUBLE);
      mode.setText("< Double Mode >");
    } else {
      mode.setUserData(GameMode.SINGLE);
      mode.setText("< Single Mode >");
    }
  }

  @FXML
  public void switchLevel() {
    switch ((GameLevel) level.getUserData()) {
      case EASY:
        level.setUserData(GameLevel.MEDIUM);
        level.setText("< MEDIUM >");
        break;
      case MEDIUM:
        level.setUserData(GameLevel.HARD);
        level.setText("< HARD >");
        break;
      case HARD:
        level.setUserData(GameLevel.EASY);
        level.setText("< EASY >");
        break;
    }
  }

  @FXML
  public void startGame() {
    SceneSwitch.INSTANCE.switchToGame(
        (GameMode) mode.getUserData(), (GameLevel) level.getUserData());
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
