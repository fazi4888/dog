package frogger.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardController {

  @FXML private ListView<String> rankList;
  @FXML private ListView<String> nameList;
  @FXML private ListView<String> scoreList;

  private List<String> ranks = new ArrayList<>();
  private List<String> names = new ArrayList<>();
  private List<String> scores = new ArrayList<>();

  private String title;

  @FXML
  public void initialize() {
    ranks.add("RANK");
    ranks.add("1ST");
    ranks.add("2ND");
    ranks.add("3RD");
    ranks.add("4TH");
    ranks.add("5TH");
    ranks.add("6TH");
    ranks.add("7TH");
    ranks.add("8TH");
    ranks.add("9TH");
    ranks.add("10TH");
    names.add("NAME");
    names.add("PLAYER1");
    names.add("AAAAAAA");
    names.add("PLAYER1");
    names.add("AAAAAAA");
    names.add("PLAYER1");
    names.add("AAAAAAA");
    names.add("PLAYER1");
    names.add("AAAAAAA");
    names.add("PLAYER1");
    names.add("AAAAAAA");
    scores.add("SCORE");
    scores.add("1200");
    scores.add("0100");
    scores.add("1200");
    scores.add("0100");
    scores.add("1200");
    scores.add("0100");
    scores.add("1200");
    scores.add("0100");
    scores.add("1200");
    scores.add("0100");
  }

  public void setTitle(String gameLevel) {
    this.title = gameLevel;
  }

  public void init() {

    initListView(ranks, rankList);
    initListView(names, nameList);
    initListView(scores, scoreList);
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
      setText(null);
      if (string != null && !empty) {
        setText(string);
      }
    }
  }
}
