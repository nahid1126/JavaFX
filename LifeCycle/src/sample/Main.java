package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler {
    private Button rotateB, blurB, scaleB;
    private Label label;
    private Rotate rotate;
    private double angle=0.0,blurvalue=1.0,factor=0.4;
    private BoxBlur blur;
    private Reflection reflection;

    private Scale scale;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Life Cycle");

        //button created
        rotateB = new Button("Rotate");
        blurB = new Button("Blur Off");
        scaleB = new Button("Scale");

        rotate=new Rotate();
        blur=new BoxBlur(1.0,1.0,1);
        scale=new Scale(factor,factor);
        reflection=new Reflection();


        //add root into stage
        label = new Label("Reflection adds visual sparkle");
        FlowPane root = new FlowPane( 9, 6);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll( rotateB, blurB, scaleB,label);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        //add event handler for button
        rotateB.setOnAction(this);
        blurB.setOnAction(this);
        scaleB.setOnAction(this);

        //use our label and apply the reflection effect
        reflection.setTopOpacity(15);
        reflection.setBottomOpacity(0.3);
        label.setEffect(reflection);

        //setup transformations
        rotateB.getTransforms().add(rotate);
        scaleB.getTransforms().add(scale);
    }


    @Override
    public void handle(Event event) {
        if (event.getSource().equals(rotateB)) {
            angle+=60;
            rotate.setAngle(angle);
            rotate.setPivotX(rotateB.getWidth()/2);
            rotate.setPivotY(rotateB.getHeight()/2);
        }
        if (event.getSource().equals(blurB)) {
            //each time button is pressed its blur
            if (blurvalue==10.0){
                blurvalue=1.0;
                blurB.setEffect(null);
                blurB.setText("Blur Off");
            }else {
                blurvalue++;
                blurB.setEffect(blur);
                blurB.setText("Blur On");
            }
            blur.setWidth(blurvalue/2);
            blur.setHeight(blurvalue/2);
        }
        if (event.getSource().equals(scaleB)) {
            factor+=0.1;
            if (factor>2.0)
                factor=0.1;
            scale.setX(factor);
            scale.setY(factor);

        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
