package frogger.util;

import frogger.constant.FileName;
import frogger.constant.RankAbbr;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

/** The {@code ScoreboardReader} is a utility to read the scoreboard file of each level. */
public class ScoreboardReader {

  private String fileName;

  /** The list of top 10 players' name. */
  private List<String> names;
  /** The list of top 10 players' score. */
  private List<String> scores;

  /**
   * Constructs a new ScoreboardReader.
   *
   * @param fileName the file name of the scoreboard file
   */
  public ScoreboardReader(String fileName) {
    this.fileName = fileName;
    this.names = new ArrayList<>();
    this.scores = new ArrayList<>();
  }

  /** Reads the file and get top 10 players' info. */
  public void read() {
    try {
      File file = new File(FileName.SCOREBOARD_DIR + fileName);
      List<String> lines = FileUtils.readLines(file, StandardCharsets.UTF_8);

      // sort lines according to players' score
      lines.sort(
          (line1, line2) -> {
            String score1 = line1.split(";", 2)[1];
            String score2 = line2.split(";", 2)[1];
            return -score1.compareTo(score2);
          });

      // add top 10 players' info to the array
      for (int i = 0; i < 10 && i < lines.size(); i++) {
        String[] strings = lines.get(i).split(";", 2);
        names.add(strings[0]);
        scores.add(strings[1]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Return the abbreviation of ranks according to number of players on the scoreboard.
   *
   * @return the abbreviation of ranks
   * @see RankAbbr
   */
  public List<String> getRanks() {
    return RankAbbr.ranks.subList(0, names.size());
  }

  public List<String> getNames() {
    return names;
  }

  public List<String> getScores() {
    return scores;
  }
}
