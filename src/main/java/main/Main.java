package main;

import components.Controller;
import components.matrix.Matrix;
import components.Title;
import components.matrix.MatrixInputter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;
    private Title title;
    private BorderPane mainBorderPane;

    public HBox centerHBox;

//    public TextField[][] leftTextFields;
//    private TextField[][] rightTextFields;

    public MatrixInputter leftMatrixInputter;
    public MatrixInputter rightMatrixInputter;

    @Override
    public void start(Stage window) throws Exception {
        window.setScene(createScene());
        window.setTitle("Matrix Calculator");
        window.setResizable(false);

        window.show();
    }

    public Scene createScene() {
        Scene scene = new Scene(createMainBorderPane(), 800, 600);

        return scene;
    }

    private BorderPane createMainBorderPane() {
        mainBorderPane = new BorderPane();

        mainBorderPane.setBottom(createBottom());
        mainBorderPane.setCenter(createCenter());
        mainBorderPane.setTop(createTop());

        return mainBorderPane;
    }

    private VBox createBottom() {
        controller = new Controller(this);

        return controller.generate();
    }

    private HBox createCenter() {
        centerHBox = new HBox();
        centerHBox.setSpacing(25);

        int leftColumns = Integer.parseInt(controller.leftMatrixSizeInputter.columnsTextField.getText());
        int leftRows = Integer.parseInt(controller.leftMatrixSizeInputter.rowsTextField.getText());

        TextField[][] leftTextFields = createMatrixTextFields(leftColumns, leftRows);

        TextField[][] rightTextFields = createMatrixTextFields(3, 4);

        Label[][] labels = new Label[3][3];

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                labels[i][j] = new Label("-");
                labels[i][j].setPrefWidth(50);
                labels[i][j].setPrefHeight(50);
                labels[i][j].setStyle("-fx-alignment: center");
            }
        }

        leftMatrixInputter = new MatrixInputter(leftTextFields);
        rightMatrixInputter = new MatrixInputter(rightTextFields);
        Matrix matrix = new Matrix(labels);

        centerHBox.getChildren().add(leftMatrixInputter.generate());
        centerHBox.getChildren().add(rightMatrixInputter.generate());
        centerHBox.getChildren().add(matrix.generate());

        return centerHBox;
    }

    public TextField[][] createMatrixTextFields(int column, int row) {
        TextField[][] textFields = new TextField[column][row];

        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                textFields[i][j] = new TextField("0");
                textFields[i][j].setPrefWidth(50);
                textFields[i][j].setPrefHeight(50);
                textFields[i][j].setStyle("-fx-alignment: center");
            }
        }

        return textFields;
    }

    private Pane createTop() {
        Title title = new Title("Matrix Calculator");

        return title.generate();
    }
}
