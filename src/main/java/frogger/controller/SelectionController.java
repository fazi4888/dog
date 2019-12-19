package frogger.controller;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.util.MusicPlayer;
import frogger.util.SceneSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/** The {@code SelectionController} is a controller for the selection view. */
public class SelectionController {

  @FXML private Button mode;
  @FXML private Button level;

  @FXML private TextField nicknameA;
  @FXML private TextField nicknameB;

  @FXML private Button musicon;
  @FXML private Button musicoff;

  private int maxTextLength = 8;

  /** Initializes the UI. */
  @FXML
  public void initialize() {
    updateMusicBtn();
    initTextListener(nicknameA);
    initTextListener(nicknameB);
    mode.setUserData(GameMode.SINGLE);
    level.setUserData(GameLevel.EASY);
    hideTextFieldB();
  }

  /**
   * Adds a limitation to the text field. i.e. max 8 characters and letter only.
   *
   * @param textField the text filed need to be listened
   */
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

  /** Called when the players clicks the game model. */
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

  /**
   * Called when the game mode is double.
   *
   * <p>Shows the text field of nickname of player B.
   */
  private void showTextFieldB() {
    nicknameB.setVisible(true);
    nicknameB.setDisable(false);
  }

  /**
   * Called when the game mode is single.
   *
   * <p>Hides the text field of nickname of player B.
   */
  private void hideTextFieldB() {
    nicknameB.setVisible(false);
    nicknameB.setDisable(true);
  }

  /** Called when player clicks the game level. */
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

  /** Starts the game. */
  @FXML
  public void startGame() {
    SceneSwitch.INSTANCE.switchToGame(
        (GameMode) mode.getUserData(),
        (GameLevel) level.getUserData(),
        nicknameA.getText(),
        nicknameB.getText());
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
