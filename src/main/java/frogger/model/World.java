package frogger.model;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import javafx.scene.layout.Pane;

import java.util.Set;

public class World {

  private Set<Log> logs;
  private Set<Turtle> turtles;
  private Set<WetTurtle> wetTurtles;
  private Set<Car> cars;

  private Set<End> ends;

  private Frog frogA;
  private Frog frogB;

  public World(GameMode gameMode) {
    frogA = new Frog("/frogger/image/frog/froggerUp.png");
  }

  public Frog getFrogA() {
    return frogA;
  }

  public Frog getFrogB() {
    return frogB;
  }

  private void load() {
    // create a WorldReader class to read logs/turtles/wetTurtles/obstacles....
  }

  public void init(Pane root) {
    //    load();

    root.getChildren().add(new Log("/frogger/image/log/log3.png", 170, 0, 222, 0.75));
    root.getChildren().add(new Log("/frogger/image/log/log3.png", 170, 220, 222, 0.75));
    root.getChildren().add(new Log("/frogger/image/log/log3.png", 170, 440, 222, 0.75));
    root.getChildren().add(new Log("/frogger/image/log/log1.png", 340, 0, 358, -2));
    root.getChildren().add(new Log("/frogger/image/log/log1.png", 340, 400, 358, -2));
    root.getChildren().add(new Log("/frogger/image/log/log3.png", 170, 50, 425, 0.75));
    root.getChildren().add(new Log("/frogger/image/log/log3.png", 170, 270, 425, 0.75));
    root.getChildren().add(new Log("/frogger/image/log/log3.png", 170, 490, 425, 0.75));

    root.getChildren().add(new Turtle(500, 485, -1, 140));
    root.getChildren().add(new Turtle(300, 485, -1, 140));
    root.getChildren().add(new WetTurtle(700, 485, -1, 140, 140));
    root.getChildren().add(new WetTurtle(600, 282, -1, 140, 140));
    root.getChildren().add(new WetTurtle(400, 282, -1, 140, 140));
    root.getChildren().add(new WetTurtle(200, 282, -1, 140, 140));

    root.getChildren().add(new Car("/frogger/image/car/truck1" + "Right.png", 0, 649, 1, 120, 120));
    root.getChildren()
        .add(new Car("/frogger/image/car/truck1" + "Right.png", 300, 649, 1, 120, 120));
    root.getChildren()
        .add(new Car("/frogger/image/car/truck1" + "Right.png", 600, 649, 1, 120, 120));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 100, 597, -1, 50, 50));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 250, 597, -1, 50, 50));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 400, 597, -1, 50, 50));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 550, 597, -1, 50, 50));
    root.getChildren().add(new Car("/frogger/image/car/truck2Right.png", 0, 540, 1, 200, 200));
    root.getChildren().add(new Car("/frogger/image/car/truck2Right.png", 500, 540, 1, 200, 200));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 500, 490, -5, 50, 50));

    root.getChildren().add(frogA);
    //    root.getChildren().add(new Digit(0, 30, 360, 25));
  }
}
