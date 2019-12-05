package frogger.util;

import frogger.constant.PreLoadActor;
import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.model.actor.AutomaticActor;
import frogger.model.actor.End;
import frogger.model.actor.Frog;
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
    resetActor();
    drawActor();
  }

  private void readActor() {
    frogA = PreLoadActor.INSTANCE.frogA;
    frogB = PreLoadActor.INSTANCE.frogB;
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

  private void resetActor() {
    frogA.reset();
    frogB.reset();
    ends.forEach(End::reset);
    automaticActors.forEach(AutomaticActor::reset);
  }

  private void drawActor() {
    root.getChildren().addAll(automaticActors);
    root.getChildren().addAll(ends);
    root.getChildren().add(frogA);
    if (isDoubleMode()) root.getChildren().add(frogB);
  }

  public Frog getFrogA() {
    return frogA;
  }

  public Frog getFrogB() {
    return isDoubleMode() ? frogB : null;
  }

  public ArrayList<AutomaticActor> getAutomaticActors() {
    return automaticActors;
  }

  public ArrayList<End> getEnds() {
    return ends;
  }

  private boolean isDoubleMode() {
    return gameMode == GameMode.DOUBLE;
  }
}
