/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_8.EnhancedFutureValueApp;

import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RodriguezEnhancedFutureValueApp extends Application {
    // Instanced Variables
    private TextField fieldMonthlyPayment = new TextField(); 
    private TextField fieldInterestRate = new TextField(); 
    private TextArea areaFinalCalc = new TextArea(); 
    private Label lblMonthlyPayment = new Label("Monthly Payment:"); 
    private Label lblInterestRate = new Label("Interest Rate:"); 
    private Label lblYears = new Label("Years:"); 
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1"); 
    private Label lblFutureValueDate = new Label(""); 
    private ComboBox<Integer> comboBoxYears = new ComboBox<>(); 
    private Button btnCalculate = new Button("Calculate"); 
    private Button btnClear = new Button("Clear"); 

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

        pane.add(lblMonthlyPayment, 0, 0); // Add the label to the grid pane.
        lblMonthlyPayment.setMinWidth(100); // Ensure the label is never cut off.
        pane.add(fieldMonthlyPayment, 1, 0); // Add the field to the grid pane.
        GridPane.setHalignment(fieldMonthlyPayment, HPos.RIGHT); // Position the field to the right of the pane.

        pane.add(lblInterestRate, 0, 1); // Add the label to the grid pane.
        pane.add(fieldInterestRate, 1, 1); // Add the field to the grid pane.
        GridPane.setHalignment(fieldInterestRate, HPos.RIGHT); // Position the label to the right of the pane.

        lblInterestRateFormat.setTextFill(Color.RED); // Set the font color of the interest rate instructions to red.
        pane.add(lblInterestRateFormat, 1, 2); // Add the label to the grid pane.
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT); // Position the label to the right of the pane.

        pane.add(lblYears, 0, 3); // Add the label to the grid pane.
        comboBoxYears.setMaxWidth(Double.MAX_VALUE); // Allow the combo box to extend as far as necessary.
        comboBoxYears.setValue(0); // Set the default value of the combo box to zero.
        pane.add(comboBoxYears, 1, 3); // Add the combo box to the grid pane.
        GridPane.setHalignment(comboBoxYears, HPos.RIGHT); // Position the combo box to the right of the pane.

        HBox actionBtnContainer = new HBox(); // Create a new HBox container.
        actionBtnContainer.setPadding(new Insets(15.0f, 0.0f, 15.0f, 30.0f)); // Set the containers padding.
        actionBtnContainer.setSpacing(10); // Set the containers spacing.
        actionBtnContainer.getChildren().add(btnClear); // Add the btnClear to the container.
        actionBtnContainer.getChildren().add(btnCalculate); // Add the btnCalculate to the container.
        pane.add(actionBtnContainer, 1, 4); // Add the container to the grid panel.
        GridPane.setHalignment(actionBtnContainer, HPos.RIGHT); // Position the buttons to the right of the pane.

        pane.add(lblFutureValueDate, 0, 5, 2, 1); // Add the future date label to the grid pane.
        GridPane.setHalignment(lblFutureValueDate, HPos.LEFT); // Position the future date label to the left of the pane.

        pane.add(areaFinalCalc, 0, 6, 2, 1); // Add the text area to the grid pane.

        // Fill the years combo box with a sample list of potential years passed.
        Integer[] years_to_select = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        comboBoxYears.setItems(FXCollections.observableArrayList(years_to_select)); 
        btnClear.setOnAction(e -> clearFormFields()); // Set the clear button to clear the form fields.
        btnCalculate.setOnAction(e -> calculateResults()); // Set the calculate button to calculate the result. 

        primaryStage.setMaxWidth(300); // Set the maximum window width.
        primaryStage.setMaxHeight(400); // Set the maximum window height.
        primaryStage.setScene(new Scene(pane)); //  Create and set the scene for the application.
        primaryStage.setTitle("Rodriguez Future Value App"); // Set the application title.
        primaryStage.show(); // Show the application.
    }

    /** 
     * Method with no arguments, which is used to clear the calculator's user input values.
     * @return a calculator app with cleared form fields.
    */
    private void clearFormFields()
    {
        fieldMonthlyPayment.setText("");
        fieldInterestRate.setText("");
        areaFinalCalc.setText("");
        lblFutureValueDate.setText("");
        comboBoxYears.setValue(0);
    }

    /** 
     * Method with no arguments, which is used to calculate the future value based on the form inputs.
     * @return a text field showcasing the calculated amount along said a label of the current date (or exception, where applicable)
    */
    private void calculateResults()
    {
        try 
        {
            // Attempt to calculate the future value by parsing the user fields
            double amount = FinanceCalculator.calculateFutureValue(Double.parseDouble(fieldMonthlyPayment.getText()), Double.parseDouble(fieldInterestRate.getText()), comboBoxYears.getValue());
            lblFutureValueDate.setText(String.format("Calculation as of %1$s", getToday()));
            areaFinalCalc.setText(String.format("The future value is $%,6.2f", amount));
        } 
        catch (NullPointerException e) 
        {
            // If a string is empty, notify the user.
            System.out.println("\n  Exception: " + e.getMessage());
            lblFutureValueDate.setText("(One of the required fields is empty!)");
        }
        catch (NumberFormatException  e) 
        {
            // If a string is invalid, notify the user.
            System.out.println("\n  Exception: " + e.getMessage());
            lblFutureValueDate.setText("(One of the required fields is invalid!)");
        }
    }

    /** 
     * Method with no arguments, which is used to get the current date in MM/dd/yyyy format.
     * @return a string of the current date in MM/dd/yyyy format.
    */
    private String getToday() 
    {
        SimpleDateFormat t = new SimpleDateFormat("MM/dd/yyyy");
        return t.format(new Date());
    }
}
