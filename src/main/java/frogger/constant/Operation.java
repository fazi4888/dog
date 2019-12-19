package frogger.constant;

import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;

/** The {@code Operation} is an object to store two sets of operation for player A and player B. */
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
          put(KeyCode.I, Direction.UP);
          put(KeyCode.J, Direction.LEFT);
          put(KeyCode.K, Direction.DOWN);
          put(KeyCode.L, Direction.RIGHT);
        }
      };
}
