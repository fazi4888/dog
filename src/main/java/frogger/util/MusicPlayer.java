package frogger.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public enum MusicPlayer {
  INSTANCE;

  private MediaPlayer mediaPlayer;
  private boolean isOn;

  public boolean isOn() {
    return isOn;
  }

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

  public void stopMusic() {
    mediaPlayer.stop();
    isOn = false;
  }
}