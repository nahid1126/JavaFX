package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler {
    private Label title, response, selected;
    private CheckBox apple, mango, banana, lichi, pine_apple;
    private String fruits;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Favorite Fruit");
        title = new Label("What fruits do you like?");

        apple = new CheckBox("Apple");
        mango = new CheckBox("Mango");
        banana = new CheckBox("Banana");
        lichi = new CheckBox("Lichi");
        pine_apple = new CheckBox("Pine Apple");
        response = new Label("");
        selected = new Label("");

        //register action all of our checkbox
        apple.setOnAction(this);
        mango.setOnAction(this);
        banana.setOnAction(this);
        lichi.setOnAction(this);
        pine_apple.setOnAction(this);

        //Setup the Stage and Scene
        FlowPane flowPaneRoot = new FlowPane(Orientation.VERTICAL, 5, 8);
        flowPaneRoot.setAlignment(Pos.TOP_CENTER);

        //We add all of our controls
        flowPaneRoot.getChildren().addAll(title, apple, mango, banana, lichi, pine_apple, response, selected);


        //attach scene to stage
        primaryStage.setScene(new Scene(flowPaneRoot, 300, 275));

        primaryStage.show();

        showAll();
    }

    void showAll() {
        fruits = "";
        if (apple.isSelected())
            fruits = "Apple";
        if (banana.isSelected())
            fruits += " Banana";
        if (mango.isSelected())
            fruits += " Mango";
        if (lichi.isSelected())
            fruits += " Lichi";
        if (pine_apple.isSelected())
            fruits += " Pine Apple";

        selected.setText("You Selected Fruit : " + fruits);
    }

    @Override
    public void handle(Event event) {
        Object fruitChecked = event.getSource();
        if (apple.equals(fruitChecked)) {
            if (apple.isSelected()) {
                response.setText("Apple Selected");
            } else response.setText("Apple Unselected");

            showAll();
        }
        if (banana.equals(fruitChecked)) {
            if (banana.isSelected()) {
                response.setText("Banana Selected");
            } else response.setText("Banana Unselected");
            showAll();
        }
        if (mango.equals(fruitChecked)) {
            if (mango.isSelected()) {
                response.setText("Mango Selected");
            } else response.setText("Mango Unselected");
            showAll();
        }
        if (lichi.equals(fruitChecked)) {
            if (lichi.isSelected()) {
                response.setText("Lichi Selected");
            } else response.setText("Lichi Unselected");
            showAll();
        }
        if (pine_apple.equals(fruitChecked)) {
            if (pine_apple.isSelected()) {
                response.setText("Pine Apple Selected");
            } else response.setText("Pine Apple Unselected");
            showAll();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
