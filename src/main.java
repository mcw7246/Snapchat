import DataHandler.Average;
import DataHandler.DataParser;
import Gui.AverageGui;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class main extends Application
{

  public static GridPane gridPane;
  @Override
  public void start(Stage primaryStage){
    gridPane = new GridPane();

    Button averageButton = new Button("Average");
    averageButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent actionEvent)
      {
        gridPane = AverageGui.averageGui(gridPane);
      }
    });

    Button searchButton = new Button("Search");
    searchButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent actionEvent)
      {

      }
    });

    gridPane.add(averageButton, 0, 0);
    gridPane.add(searchButton, 0, 1);

    gridPane.setPadding(new Insets(20));
    gridPane.setVgap(20);
    gridPane.setHgap(20);

    Scene scene = new Scene(gridPane);

    gridPane.setPrefSize(500, 300);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Snapchat Analysis");
    primaryStage.show();
  }
  public static void main(String[] args){
    DataParser.parseData();
    Average.getAverageAll();
    launch(args);
  }
}
