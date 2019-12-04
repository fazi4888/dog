package frogger.util;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import frogger.constant.FileName;
import frogger.model.*;
import javafx.scene.layout.Pane;

import java.util.HashSet;
import java.util.Set;

public class WorldLoader {
  private Pane root;
  private GameMode gameMode;
  private GameLevel gameLevel;

  private Frog frogA;
  private Frog frogB;

  private Set<Log> logs;
  private Set<Turtle> turtles;
  private Set<WetTurtle> wetTurtles;
  private Set<Car> cars;

  private Set<End> ends;

  public WorldLoader(GameMode gameMode, GameLevel gameLevel, Pane root) {

    this.root = root;
    this.gameMode = gameMode;
    this.gameLevel = gameLevel;

    this.logs = new HashSet<>();
    this.turtles = new HashSet<>();
    this.wetTurtles = new HashSet<>();
    this.cars = new HashSet<>();

    this.ends = new HashSet<>();

    readActor();
    drawActor();
  }

  private void readActor() {
    frogA = new Frog(FileName.IMAGE_FROG_UP, 150);
    frogB = (gameMode == GameMode.DOUBLE) ? new Frog(FileName.IMAGE_FROG_UP, 600) : null;

    ends.add(new End(14, 134));
    ends.add(new End(179, 134));
    ends.add(new End(343, 134));
    ends.add(new End(505, 134));
    ends.add(new End(672, 134));

    if (gameLevel == GameLevel.EASY) {
      logs.add(new Log(FileName.IMAGE_LOG_SHORT, 170, 0, 222, 0.75));
      logs.add(new Log(FileName.IMAGE_LOG_SHORT, 170, 315, 222, 0.75));
      logs.add(new Log(FileName.IMAGE_LOG_SHORT, 170, 630, 222, 0.75));
      logs.add(new Log(FileName.IMAGE_LOG_LONG, 340, 0, 358, -2));
      logs.add(new Log(FileName.IMAGE_LOG_LONG, 340, 540, 358, -2));
      logs.add(new Log(FileName.IMAGE_LOG_SHORT, 170, 50, 425, 0.75));
      logs.add(new Log(FileName.IMAGE_LOG_SHORT, 170, 330, 425, 0.75));
      logs.add(new Log(FileName.IMAGE_LOG_SHORT, 170, 610, 425, 0.75));

      turtles.add(new Turtle(FileName.IMAGE_TURTLE_2, 240, 485, 140, -1));
      turtles.add(new Turtle(FileName.IMAGE_TURTLE_2, 440, 485, 140, -1));
      wetTurtles.add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 640, 485, 140, -1));
      wetTurtles.add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 100, 282, 140, -1));
      wetTurtles.add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 350, 282, 140, -1));
      wetTurtles.add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 700, 282, 140, -1));

      cars.add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 0, 890, 140, 1));
      cars.add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 300, 890, 140, 1));
      cars.add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 600, 890, 140, 1));
      cars.add(new Car(FileName.IMAGE_CAR_LEFT, 100, 810, 60, -1));
      cars.add(new Car(FileName.IMAGE_CAR_LEFT, 300, 810, 60, -1));
      cars.add(new Car(FileName.IMAGE_CAR_LEFT, 500, 810, 60, -1));
      cars.add(new Car(FileName.IMAGE_CAR_LEFT, 700, 810, 60, -1));
      cars.add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 0, 730, 230, 1));
      cars.add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 500, 730, 230, 1));
      cars.add(new Car(FileName.IMAGE_CAR_LEFT, 500, 660, 60, -5));
    }
  }

  private void drawActor() {
    root.getChildren().addAll(logs);
    root.getChildren().addAll(turtles);
    root.getChildren().addAll(wetTurtles);
    root.getChildren().addAll(cars);
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

  public Set<Log> getLogs() {
    return logs;
  }

  public Set<Turtle> getTurtles() {
    return turtles;
  }

  public Set<WetTurtle> getWetTurtles() {
    return wetTurtles;
  }

  public Set<Car> getCars() {
    return cars;
  }

  public Set<End> getEnds() {
    return ends;
  }
}
