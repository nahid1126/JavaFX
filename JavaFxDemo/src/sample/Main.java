package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
    private Label mylabel, label;
    private TextField textField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello JavaFX");
        Button button = new Button("Click Me!");

        mylabel = new Label("What is Your name ?");
        textField = new TextField();
        label = new Label();
        textField.setPromptText("Enter Your Name");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = textField.getText().trim();
                label.setText("Hello! " + name);
            }
        });
        FlowPane flowPaneRoot = new FlowPane(20, 10);
        flowPaneRoot.setAlignment(Pos.CENTER);
        // StackPane root=new StackPane();
        flowPaneRoot.getChildren().add(mylabel);
        flowPaneRoot.getChildren().add(textField);
        flowPaneRoot.getChildren().add(button);
        flowPaneRoot.getChildren().add(label);
        primaryStage.setScene(new Scene(flowPaneRoot, 200, 250));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
