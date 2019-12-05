package frogger.constant;

import frogger.model.actor.*;

import java.util.ArrayList;

public enum PreLoadActor {
  INSTANCE;

  public Frog frogA = new Frog(FileName.IMAGE_FROG_UP, 150);
  public Frog frogB = new Frog(FileName.IMAGE_FROG_UP, 600);

  public ArrayList<End> ends =
      new ArrayList<>() {
        {
          add(new End(14, 134));
          add(new End(179, 134));
          add(new End(343, 134));
          add(new End(505, 134));
          add(new End(672, 134));
        }
      };

  public ArrayList<AutomaticActor> easyAutoActors =
      new ArrayList<>() {
        {
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 0, 222, 0.75));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 315, 222, 0.75));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 630, 222, 0.75));
          add(new Log(FileName.IMAGE_LOG_LONG, 340, 0, 358, -2));
          add(new Log(FileName.IMAGE_LOG_LONG, 340, 540, 358, -2));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 50, 425, 0.75));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 330, 425, 0.75));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 610, 425, 0.75));

          add(new Turtle(FileName.IMAGE_TURTLE_2, 240, 485, 140, -1));
          add(new Turtle(FileName.IMAGE_TURTLE_2, 440, 485, 140, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 640, 485, 140, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 100, 282, 140, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 350, 282, 140, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 700, 282, 140, -1));

          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 0, 890, 140, 1));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 300, 890, 140, 1));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 600, 890, 140, 1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 100, 810, 60, -1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 300, 810, 60, -1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 500, 810, 60, -1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 700, 810, 60, -1));
          add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 0, 730, 230, 1));
          add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 500, 730, 230, 1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 500, 660, 60, -5));
        }
      };

  public ArrayList<AutomaticActor> mediumAutoActors =
      new ArrayList<>() {
        {
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 0, 222, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 315, 222, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 630, 222, 1));
          add(new Log(FileName.IMAGE_LOG_LONG, 340, 0, 358, -2.5));
          add(new Log(FileName.IMAGE_LOG_LONG, 340, 540, 358, -2.5));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 50, 425, 1.3));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 330, 425, 1.3));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 610, 425, 1.3));

          add(new Turtle(FileName.IMAGE_TURTLE_2, 240, 485, 140, -1.2));
          add(new Turtle(FileName.IMAGE_TURTLE_2, 440, 485, 140, -1.2));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 640, 485, 140, -1.2));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 100, 282, 140, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 350, 282, 140, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 700, 282, 140, -1));

          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 0, 890, 140, 1.2));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 300, 890, 140, 1.2));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 600, 890, 140, 1.2));
          add(new Car(FileName.IMAGE_CAR_LEFT, 100, 810, 60, -1.3));
          add(new Car(FileName.IMAGE_CAR_LEFT, 300, 810, 60, -1.3));
          add(new Car(FileName.IMAGE_CAR_LEFT, 500, 810, 60, -1.3));
          add(new Car(FileName.IMAGE_CAR_LEFT, 700, 810, 60, -1.3));
          add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 0, 730, 230, 1.2));
          add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 500, 730, 230, 1.2));
          add(new Car(FileName.IMAGE_CAR_LEFT, 700, 660, 60, -5));
          add(new Car(FileName.IMAGE_CAR_LEFT, 300, 660, 60, -5));
        }
      };

  public ArrayList<AutomaticActor> hardAutoActors =
      new ArrayList<>() {
        {
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 0, 222, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 315, 222, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 630, 222, 1));
          add(new Log(FileName.IMAGE_LOG_MEDIUM, 250, 0, 358, -2.5));
          add(new Log(FileName.IMAGE_LOG_MEDIUM, 250, 540, 358, -2.5));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 50, 425, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 330, 425, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 170, 610, 425, 1));

          add(new Turtle(FileName.IMAGE_TURTLE_2, 240, 485, 140, -1.4));
          add(new Turtle(FileName.IMAGE_TURTLE_2, 440, 485, 140, -1.4));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 640, 485, 140, -1.4));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 100, 282, 140, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 350, 282, 140, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 700, 282, 140, -1));

          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 0, 890, 140, 2));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 300, 890, 140, 2));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 600, 890, 140, 2));
          add(new Car(FileName.IMAGE_CAR_LEFT, 100, 810, 60, -2.2));
          add(new Car(FileName.IMAGE_CAR_LEFT, 300, 810, 60, -2.2));
          add(new Car(FileName.IMAGE_CAR_LEFT, 500, 810, 60, -2.2));
          add(new Car(FileName.IMAGE_CAR_LEFT, 700, 810, 60, -2.2));
          add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 0, 730, 230, 2));
          add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 500, 730, 230, 2));
          add(new Car(FileName.IMAGE_CAR_LEFT, 700, 660, 60, -5));
          add(new Car(FileName.IMAGE_CAR_LEFT, 300, 660, 60, -5));
        }
      };
}
