package frogger.util;

import frogger.constant.FileName;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ScoreboardWriter {

  private String destFileName;

  public ScoreboardWriter(String destFileName) {
    this.destFileName = destFileName;
  }

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
