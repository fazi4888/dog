package frogger.model;

import frogger.constant.GameLevel;
import frogger.constant.GameMode;
import javafx.scene.layout.Pane;

import java.util.Set;

public class World {
  private Pane root;

  private Set<Log> logs;
  private Set<Turtle> turtles;
  private Set<WetTurtle> wetTurtles;
  private Set<Car> cars;

  private Set<End> ends;

  private Frog frogA;
  private Frog frogB;

  public World(GameMode gameMode, Pane root) {
    frogA = new Frog("/frogger/image/frog/froggerUp.png");
    this.root = root;
    init(root);
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

    root.getChildren()
        .add(new Turtle("/frogger/image/turtle/TurtleAnimation2.png", 500, 485, 140, -1));
    root.getChildren()
        .add(new Turtle("/frogger/image/turtle/TurtleAnimation2.png", 300, 485, 140, -1));
    root.getChildren()
        .add(new WetTurtle("/frogger/image/turtle/TurtleAnimation2Wet.png", 700, 485, 140, -1));
    root.getChildren()
        .add(new WetTurtle("/frogger/image/turtle/TurtleAnimation2Wet.png", 600, 282, 140, -1));
    root.getChildren()
        .add(new WetTurtle("/frogger/image/turtle/TurtleAnimation2Wet.png", 400, 282, 140, -1));
    root.getChildren()
        .add(new WetTurtle("/frogger/image/turtle/TurtleAnimation2Wet.png", 200, 282, 140, -1));

    root.getChildren().add(new Car("/frogger/image/car/truck1" + "Right.png", 0, 649, 120, 120, 1));
    root.getChildren()
        .add(new Car("/frogger/image/car/truck1" + "Right.png", 300, 649, 120, 120, 1));
    root.getChildren()
        .add(new Car("/frogger/image/car/truck1" + "Right.png", 600, 649, 120, 120, 1));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 100, 597, 50, 50, -1));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 250, 597, 50, 50, -1));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 400, 597, 50, 50, -1));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 550, 597, 50, 50, -1));
    root.getChildren().add(new Car("/frogger/image/car/truck2Right.png", 0, 540, 200, 200, 1));
    root.getChildren().add(new Car("/frogger/image/car/truck2Right.png", 500, 540, 200, 200, 1));
    root.getChildren().add(new Car("/frogger/image/car/car1Left.png", 500, 490, 50, 50, -5));

    root.getChildren().add(frogA);
  }
}
