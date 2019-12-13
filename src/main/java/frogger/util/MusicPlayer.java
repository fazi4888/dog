package frogger.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * The {@code MusicPlayer} class is a utility to {@link #playMusic()} or {@link #stopMusic()}.
 *
 * <p><b>Note:</b> this class is a singleton with {@link Enum}.
 */
public enum MusicPlayer {
  INSTANCE;

  /** The {@link MediaPlayer} for background music. */
  private MediaPlayer mediaPlayer;
  /** Is the background music on. */
  private boolean isOn;

  /**
   * Returns is the background music on.
   *
   * @return {@code true} if the background music is on; {@code false} otherwise.
   */
  public boolean isOn() {
    return isOn;
  }

  /** Plays the background music. */
  public void playMusic() {
    ClassLoader classLoader = getClass().getClassLoader();
    URL resource = classLoader.getResource("frogger/music/Frogger Main Song Theme (loop).mp3");
    String path = null;
    try {
      path = Objects.requireNonNull(resource).toURI().getPath();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
    Media sound = new Media(new File(Objects.requireNonNull(path)).toURI().toString());
    mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    mediaPlayer.play();
    isOn = true;
  }

  /** Stops the background music. */
  public void stopMusic() {
    mediaPlayer.stop();
    isOn = false;
  }
}
