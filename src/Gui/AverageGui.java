package Gui;

import DataHandler.Average;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Map;

public class AverageGui
{

  public static GridPane averageGui(GridPane gridPane){
    GridPane updated = gridPane;
    updated.getChildren().clear();

    Map<String, Double> averageAll = Average.getAverageAll();

    ObservableMap<String, Double> users = FXCollections.observableMap(averageAll);

    TableView<Map<String, Double>> table = new TableView<>();


    return updated;
  }
}
