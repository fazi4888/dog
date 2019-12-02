package frogger.constant;

import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

public class Operation {
  public static final Map<KeyCode, Direction> DIRECTION_A =
      new HashMap<>() {
        {
          put(KeyCode.W, Direction.UP);
          put(KeyCode.A, Direction.LEFT);
          put(KeyCode.S, Direction.DOWN);
          put(KeyCode.D, Direction.RIGHT);
        }
      };
  public static final Map<KeyCode, Direction> DIRECTION_B =
      new HashMap<>() {
        {
          put(KeyCode.UP, Direction.UP);
          put(KeyCode.LEFT, Direction.LEFT);
          put(KeyCode.DOWN, Direction.DOWN);
          put(KeyCode.RIGHT, Direction.RIGHT);
        }
      };
}
