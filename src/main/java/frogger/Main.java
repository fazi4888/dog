package frogger;

import frogger.util.MusicPlayer;
import frogger.util.SceneSwitch;
import javafx.application.Application;
import javafx.stage.Stage;

/** The {@code Main} class of the application. */
public class Main extends Application {

  private static Stage primaryStage;

  public static void main(String[] args) {
    launch(args);
  }

  public static Stage getPrimaryStage() {
    return primaryStage;
  }

  /**
   * The main entry point for the application.
   *
   * @param primaryStage the primary stage
   */
  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;

    primaryStage.setTitle("Frogger");
    primaryStage.setResizable(false);

    MusicPlayer.INSTANCE.playMusic();
    SceneSwitch.INSTANCE.switchToHome();
  }
}
