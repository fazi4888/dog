package frogger.constant;

import frogger.model.actor.*;

import java.util.ArrayList;

/**
 * The {@code PreloadedActor} is an object to store two frogs, ends and other actors in different
 * game level.
 */
public class PreloadedActor {

  public static Frog frogA = new Frog(FileName.IMAGE_FROG_UP, 100, 720);
  public static Frog frogB = new Frog(FileName.IMAGE_FROG_UP, 450, 720);

  public static ArrayList<End> ends =
      new ArrayList<>() {
        {
          add(new End(11, 101));
          add(new End(134, 101));
          add(new End(255, 101));
          add(new End(378, 101));
          add(new End(500, 101));
        }
      };

  public static ArrayList<AutomaticActor> easyAutoActors =
      new ArrayList<>() {
        {
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 0, 166, 0.75));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 220, 166, 0.75));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 440, 166, 0.75));
          add(new Log(FileName.IMAGE_LOG_LONG, 250, 0, 268, -2));
          add(new Log(FileName.IMAGE_LOG_LONG, 250, 440, 268, -2));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 50, 320, 0.75));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 270, 320, 0.75));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 490, 320, 0.75));

          add(new Turtle(FileName.IMAGE_TURTLE_2, 240, 360, 120, -1));
          add(new Turtle(FileName.IMAGE_TURTLE_2, 440, 360, 120, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 640, 360, 120, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 450, 206, 120, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 300, 206, 120, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 150, 206, 120, -1));

          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 0, 660, 115, 1));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 225, 660, 115, 1));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_RIGHT, 450, 660, 115, 1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 75, 600, 50, -1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 225, 600, 50, -1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 375, 600, 50, -1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 525, 600, 50, -1));
          add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 0, 540, 200, 1));
          add(new Car(FileName.IMAGE_TRUCK_LONG_RIGHT, 380, 540, 200, 1));
          add(new Car(FileName.IMAGE_CAR_LEFT, 470, 480, 50, -5));
        }
      };

  public static ArrayList<AutomaticActor> mediumAutoActors =
      new ArrayList<>() {
        {
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 0, 166, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 220, 166, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 440, 166, 1));
          add(new Log(FileName.IMAGE_LOG_LONG, 250, 0, 268, -2.5));
          add(new Log(FileName.IMAGE_LOG_LONG, 250, 440, 268, -2.5));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 50, 320, 1.3));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 270, 320, 1.3));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 490, 320, 1.3));

          add(new Turtle(FileName.IMAGE_TURTLE_2, 240, 360, 120, -1.2));
          add(new Turtle(FileName.IMAGE_TURTLE_2, 440, 360, 120, -1.2));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 640, 360, 120, -1.2));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 450, 206, 120, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 300, 206, 120, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 150, 206, 120, -1));

          add(new Car(FileName.IMAGE_TRUCK_SHORT_LEFT, 0, 660, 115, -1.2));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_LEFT, 225, 660, 115, -1.2));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_LEFT, 450, 660, 115, -1.2));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 75, 600, 50, 1.3));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 225, 600, 50, 1.3));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 375, 600, 50, 1.3));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 525, 600, 50, 1.3));
          add(new Car(FileName.IMAGE_TRUCK_LONG_LEFT, 0, 540, 200, -1.2));
          add(new Car(FileName.IMAGE_TRUCK_LONG_LEFT, 380, 540, 200, -1.2));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 470, 480, 50, 5));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 270, 480, 50, 5));
        }
      };

  public static ArrayList<AutomaticActor> hardAutoActors =
      new ArrayList<>() {
        {
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 0, 166, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 220, 166, 1));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 440, 166, 1));
          add(new Log(FileName.IMAGE_LOG_MEDIUM, 183, 0, 268, -2.5));
          add(new Log(FileName.IMAGE_LOG_MEDIUM, 183, 440, 268, -2.5));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 50, 320, 1.3));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 270, 320, 1.3));
          add(new Log(FileName.IMAGE_LOG_SHORT, 125, 490, 320, 1.3));

          add(new Turtle(FileName.IMAGE_TURTLE_2, 240, 360, 120, -1.4));
          add(new Turtle(FileName.IMAGE_TURTLE_2, 440, 360, 120, -1.4));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 640, 360, 120, -1.4));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 450, 206, 120, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 300, 206, 120, -1));
          add(new WetTurtle(FileName.IMAGE_WETTURTLE_1, 150, 206, 120, -1));

          add(new Car(FileName.IMAGE_TRUCK_SHORT_LEFT, 0, 660, 115, -1.5));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_LEFT, 225, 660, 115, -1.5));
          add(new Car(FileName.IMAGE_TRUCK_SHORT_LEFT, 450, 660, 115, -1.5));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 75, 600, 50, 2));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 225, 600, 50, 2));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 375, 600, 50, 2));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 525, 600, 50, 2));
          add(new Car(FileName.IMAGE_TRUCK_LONG_LEFT, 0, 540, 200, -1.8));
          add(new Car(FileName.IMAGE_TRUCK_LONG_LEFT, 380, 540, 200, -1.8));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 470, 480, 50, 5));
          add(new Car(FileName.IMAGE_CAR_RIGHT, 270, 480, 50, 5));
        }
      };
}
