/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Capstone.GradeBookApp;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RodriguezGradeBookApp extends Application {
    // Instanced Variables
    private TextField fieldFirstName = new TextField(); 
    private TextField fieldLastName = new TextField(); 
    private TextField fieldCourse = new TextField(); 
    private ComboBox<String> comboBoxGrade = new ComboBox<>(); 
    private Label lblFirstName = new Label("First Name:"); 
    private Label lblLastName = new Label("Last Name:"); 
    private Label lblCourse = new Label("Course:"); 
    private Label lblGrade = new Label("Grade:"); 
    private Button btnClearForm = new Button("Clear Form"); 
    private Button btnViewGrades = new Button("View Grades"); 
    private Button btnSaveGrade = new Button("Save Grade"); 

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    // Extend the JavaFX Stage
    @Override
    public void start(Stage primaryStage) 
    {
        GridPane pane = new GridPane(); // Setup a grid pane for all objects to be auto-arranged into.
        pane.setAlignment(Pos.CENTER); // Set the alignment of the pane to the center.
        pane.setPadding(new Insets(11.5f, 12.5f, 13.5f, 14.5f)); // Set the insets of the pane.
        pane.setHgap(5.5); // Set the horizontal gap of the pane.
        pane.setVgap(5.5); // Set the vertical gap of the pane.

        pane.add(lblFirstName, 0, 0); // Add the label to the grid pane.
        pane.add(fieldFirstName, 1, 0); // Add the field to the grid pane.
        GridPane.setHalignment(fieldFirstName, HPos.RIGHT); // Position the field to the right of the pane.

        pane.add(lblLastName, 0, 1); // Add the label to the grid pane.
        pane.add(fieldLastName, 1, 1); // Add the field to the grid pane.
        GridPane.setHalignment(fieldLastName, HPos.RIGHT); // Position the label to the right of the pane.

        pane.add(lblCourse, 0, 2); // Add the label to the grid pane.
        pane.add(fieldCourse, 1, 2); // Add the field to the grid pane.
        GridPane.setHalignment(fieldCourse, HPos.RIGHT); // Position the label to the right of the pane.

        pane.add(btnClearForm, 1, 3); // Add the field to the grid pane.
        GridPane.setHalignment(btnClearForm, HPos.RIGHT); // Position the label to the right of the pane.

        pane.add(lblGrade, 0, 4); // Add the label to the grid pane.
        comboBoxGrade.setMaxWidth(Double.MAX_VALUE); // Allow the combo box to extend as far as necessary.
        pane.add(comboBoxGrade, 1, 4); // Add the combo box to the grid pane.
        GridPane.setHalignment(comboBoxGrade, HPos.RIGHT); // Position the combo box to the right of the pane.
        
        HBox actionBtnContainer = new HBox(); // Create a new HBox container.
        actionBtnContainer.setPadding(new Insets(15.0f, 0.0f, 15.0f, 30.0f)); // Set the containers padding.
        actionBtnContainer.setSpacing(10); // Set the containers spacing.
        actionBtnContainer.getChildren().add(btnViewGrades); // Add the btnClear to the container.
        actionBtnContainer.getChildren().add(btnSaveGrade); // Add the btnCalculate to the container.
        pane.add(actionBtnContainer, 1, 5); // Add the container to the grid panel.
        GridPane.setHalignment(actionBtnContainer, HPos.RIGHT); // Position the buttons to the right of the pane.

        primaryStage.setMaxWidth(600); // Set the maximum window width.
        primaryStage.setMaxHeight(400); // Set the maximum window height.
        primaryStage.setScene(new Scene(pane)); //  Create and set the scene for the application.
        primaryStage.setTitle("Rodriguez Grade Book App"); // Set the application title.
        primaryStage.show(); // Show the application.
    }
}
