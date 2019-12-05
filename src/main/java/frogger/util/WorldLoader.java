package frogger.util;

import frogger.constant.PreLoadActor;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.constant.FileName;
import frogger.model.*;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class WorldLoader {

  private Pane root;
  private GameMode gameMode;
  private GameLevel gameLevel;

  private Frog frogA;
  private Frog frogB;
  private ArrayList<AutomaticActor> automaticActors;
  private ArrayList<End> ends;

  public WorldLoader(GameMode gameMode, GameLevel gameLevel, Pane root) {
    this.root = root;
    this.gameMode = gameMode;
    this.gameLevel = gameLevel;

    this.automaticActors = new ArrayList<>();
    this.ends = new ArrayList<>();

    readActor();
    drawActor();
  }

  private void readActor() {
    frogA = new Frog(FileName.IMAGE_FROG_UP, 150);
    frogB = (gameMode == GameMode.DOUBLE) ? new Frog(FileName.IMAGE_FROG_UP, 600) : null;
    ends = PreLoadActor.INSTANCE.ends;
    switch (gameLevel) {
      case EASY:
        automaticActors = PreLoadActor.INSTANCE.easyAutoActors;
        break;
      case MEDIUM:
        automaticActors = PreLoadActor.INSTANCE.mediumAutoActors;
        break;
      case HARD:
        automaticActors = PreLoadActor.INSTANCE.hardAutoActors;
        break;
    }
  }

  private void drawActor() {
    root.getChildren().addAll(automaticActors);
    root.getChildren().addAll(ends);
    root.getChildren().add(frogA);
    if (frogB != null) root.getChildren().add(frogB);
  }

  public Frog getFrogA() {
    return frogA;
  }

  public Frog getFrogB() {
    return frogB;
  }

  public ArrayList<AutomaticActor> getAutomaticActors() {
    return automaticActors;
  }

  public ArrayList<End> getEnds() {
    return ends;
  }
}
