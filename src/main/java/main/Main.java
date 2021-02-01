package main;

import components.controller.Controller;
import components.Title;
import components.matrix.Matrix;
import components.matrix.MatrixInputter;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import util.MatrixUtil;

public class Main extends Application {
    private Title title;
    private BorderPane mainBorderPane;
    private Controller controller;

    private HBox centerHBox;
    private MatrixInputter leftMatrixInputter;
    private MatrixInputter rightMatrixInputter;
    private Matrix matrix;

    public MatrixInputter getLeftMatrixInputter() {
        return leftMatrixInputter;
    }
    public MatrixInputter getRightMatrixInputter() {
        return rightMatrixInputter;
    }
    public Matrix getMatrix() {
        return matrix;
    }

    @Override
    public void start(Stage window) throws Exception {
        window.setScene(createScene());
        window.setTitle("Matrix Calculator");
        window.setResizable(false);

        window.show();
    }

    private Scene createScene() {
        Scene scene = new Scene(createMainBorderPane(), 800, 600);

        return scene;
    }

    private BorderPane createMainBorderPane() {
        mainBorderPane = new BorderPane();

        mainBorderPane.setTop(createTop());

        mainBorderPane.setCenter(createCenter());

        mainBorderPane.setBottom(createBottom());

        return mainBorderPane;
    }

    private VBox createBottom() {
        controller = new Controller(this);

        return controller.getVBox();
    }

    private HBox createCenter() {
        centerHBox = new HBox();
        centerHBox.setAlignment(Pos.CENTER);
        centerHBox.setSpacing(25);

        TextField[][] leftTextFields = MatrixUtil.createMatrixTextFields(3, 3);
        TextField[][] rightTextFields = MatrixUtil.createMatrixTextFields(3, 3);
        Label[][] labels = MatrixUtil.createMatrixLabels(3, 3);

        leftMatrixInputter = new MatrixInputter(leftTextFields);
        rightMatrixInputter = new MatrixInputter(rightTextFields);
        matrix = new Matrix(labels);

        centerHBox.getChildren().addAll(leftMatrixInputter.getGridPane(), rightMatrixInputter.getGridPane(), matrix.getPane());

        return centerHBox;
    }

    private Pane createTop() {
        title = new Title("Matrix Calculator");

        return title.getPane();
    }
}
