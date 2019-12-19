package frogger.util;

import frogger.constant.FileName;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/** The {@code ScoreboardWriter} is a utility to write the player info to a scoreboard file. */
public class ScoreboardWriter {

  /** The file name of the scoreboard file. */
  private String destFileName;

  /**
   * Constructs a new ScoreboardWriter.
   *
   * @param destFileName the file name of the scoreboard file
   */
  public ScoreboardWriter(String destFileName) {
    this.destFileName = destFileName;
  }

  /**
   * Write a new line to the file.
   *
   * <p>The scoreboard file will be created if it does not exist.
   *
   * @param content the content need to be written
   */
  public void write(String content) {
    new File(FileName.SCOREBOARD_DIR).mkdirs();
    File destFile = new File(FileName.SCOREBOARD_DIR + destFileName);
    try {
      FileUtils.writeStringToFile(destFile, content, StandardCharsets.UTF_8, true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
