package edu.miracosta.cs112.lab07;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;              
import javafx.scene.Scene;              
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;     
import javafx.event.EventHandler;            
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;



public class HelloApplication extends Application implements ChangeListener<Number>, EventHandler<MouseEvent> { //inheriting core functionality + this class will handle events
    /*** GUI COMPONENTS ***/
    int buttonPresses = 0; // counter for button presses
    Button firstButton = new Button("First Button");
    Button secondButton = new Button("Second Button");
    Label label = new Label("Hello GUI World!");
    Label label2 = new Label("Button Presses: " + buttonPresses);
    Pane layout = new Pane();
    Scene scene = new Scene(layout, 400, 300);
    TextField textField = new TextField("Enter text here"); // TextField for user input

    @Override
    public void start(Stage stage) throws Exception {
        
        layout.getChildren().addAll(label, label2, firstButton, secondButton, textField); // Add components to the layout
        
        stage.setScene(scene);
        stage.setTitle("Hello GUI: Zachary Croteau"); 
        stage.show();

        scene.widthProperty().addListener(this);
        scene.heightProperty().addListener(this);
        firstButton.setOnMouseClicked(this);
        secondButton.setOnMouseClicked(this);

        label.setLayoutX(scene.getWidth() - label.getWidth() - 10);
        label.setLayoutY(10);
        firstButton.setLayoutY(scene.getHeight() - firstButton.getHeight() - 10);
        firstButton.setLayoutX(10);
        secondButton.setLayoutY(scene.getHeight() - secondButton.getHeight() - 10);
        secondButton.setLayoutX(scene.getWidth() - secondButton.getWidth() - 10);

        textField.setLayoutX(scene.getWidth() / 2 - textField.getWidth() / 2);
        textField.setLayoutY(scene.getHeight() / 2 - textField.getHeight() / 2 );
        label2.setLayoutX(10);
        label2.setLayoutY(10);
        
        
        
      }  
    
    @Override
    public void changed(ObservableValue<? extends Number>obs, Number oldVal, Number newVal) {
        label.setLayoutX(scene.getWidth() - label.getWidth() - 10);
        secondButton.setLayoutX(scene.getWidth() - secondButton.getWidth() - 10);
        firstButton.setLayoutY(scene.getHeight() - firstButton.getHeight() - 10);
        secondButton.setLayoutY(scene.getHeight() - secondButton.getHeight() - 10);
        textField.setLayoutX(scene.getWidth() / 2 - textField.getWidth() / 2);
        textField.setLayoutY(scene.getHeight() / 2 - textField.getHeight() / 2 );
    }
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == firstButton) {
            label.setText(textField.getText());
        } else if (event.getSource() == secondButton) {
            buttonPresses++;
            label2.setText("Button Presses: " + buttonPresses);
        }
    }
    
    public static void main(String[] args) {
        launch(args); 
    }


    
}