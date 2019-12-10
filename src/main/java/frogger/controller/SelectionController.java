package frogger.controller;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.util.MusicPlayer;
import frogger.util.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SelectionController {

  @FXML private Button mode;
  @FXML private Button level;

  @FXML private TextField nicknameA;
  @FXML private TextField nicknameB;

  @FXML private Button musicon;
  @FXML private Button musicoff;

  private int maxTextLength = 8;

  @FXML
  public void initialize() {
    updateMusicBtn();
    initTextListener(nicknameA);
    initTextListener(nicknameB);
    mode.setUserData(GameMode.SINGLE);
    level.setUserData(GameLevel.EASY);
    hideTextFieldB();
  }

  private void initTextListener(TextField textField) {
    textField.textProperty().addListener((obs, oldValue, newValue) -> {
      String temp = newValue;
      temp = temp.replaceAll("[^a-zA-Z]", "");
      if (temp.length() > maxTextLength) {
        temp = temp.substring(0, maxTextLength);
      }
      textField.setText(temp);
    });
  }

  @FXML
  public void switchMode() {
    if (mode.getUserData() == GameMode.SINGLE) {
      mode.setUserData(GameMode.DOUBLE);
      mode.setText("< DOUBLE MODE >");
      showTextFieldB();
    } else {
      mode.setUserData(GameMode.SINGLE);
      mode.setText("< SINGLE MODE >");
      hideTextFieldB();
    }
  }

  private void showTextFieldB() {
    nicknameB.setVisible(true);
    nicknameB.setDisable(false);
  }

  private void hideTextFieldB() {
    nicknameB.setVisible(false);
    nicknameB.setDisable(true);
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
    SceneSwitch.INSTANCE.switchToGame((GameMode) mode.getUserData(), (GameLevel) level.getUserData(), nicknameA.getText(), nicknameB.getText());
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
