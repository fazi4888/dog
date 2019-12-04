package frogger.model;

import frogger.util.WorldLoader;
import javafx.scene.layout.Pane;

import java.util.Set;

public class World {
  private Pane root;

  private Frog frogA;
  private Frog frogB;

  private Set<Log> logs;
  private Set<Turtle> turtles;
  private Set<WetTurtle> wetTurtles;
  private Set<Car> cars;

  private Set<End> ends;

  public World(WorldLoader worldLoader) {
    frogA = worldLoader.getFrogA();
    frogB = worldLoader.getFrogB();

    logs = worldLoader.getLogs();
    turtles = worldLoader.getTurtles();
    wetTurtles = worldLoader.getWetTurtles();
    cars = worldLoader.getCars();

    ends = worldLoader.getEnds();
  }

  public Frog getFrogA() {
    return frogA;
  }

  public Frog getFrogB() {
    return frogB;
  }
}
