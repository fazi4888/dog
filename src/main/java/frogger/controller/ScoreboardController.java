package frogger.controller;

import frogger.util.ScoreboardReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

/** The {@code ScoreboardController} is a controller for the scoreboard view. */
public class ScoreboardController {

  /** The list of abbreviations of ranks. */
  @FXML private ListView<String> rankList;
  /** The list of top 10 players' name. */
  @FXML private ListView<String> nameList;
  /** The list of top 10 players' score. */
  @FXML private ListView<String> scoreList;

  private List<String> ranks = new ArrayList<>();
  private List<String> names = new ArrayList<>();
  private List<String> scores = new ArrayList<>();

  private String gameLevel;

  public void setGameLevel(String gameLevel) {
    this.gameLevel = gameLevel;
  }

  /** Initializes the data and list view. */
  public void init() {
    initData();
    initListView(ranks, rankList);
    initListView(names, nameList);
    initListView(scores, scoreList);
  }

  /** Reads data from the scoreboard file. */
  private void initData() {
    ranks.add("RANK");
    names.add("NAME");
    scores.add("SCORE");

    ScoreboardReader scoreboardReader = new ScoreboardReader(gameLevel.toLowerCase() + ".txt");
    scoreboardReader.read();
    ranks.addAll(scoreboardReader.getRanks());
    names.addAll(scoreboardReader.getNames());
    scores.addAll(scoreboardReader.getScores());
  }

  private void initListView(List<String> stringList, ListView<String> listView) {
    ObservableList<String> observableList = FXCollections.observableArrayList();
    observableList.addAll(stringList);
    listView.setItems(observableList);
    listView.setCellFactory(param -> new listViewCell());
  }

  private class listViewCell extends ListCell<String> {
    @Override
    protected void updateItem(String string, boolean empty) {
      super.updateItem(string, empty);
      if (empty || string == null) setText(null);
      else setText(string);
    }
  }
}
