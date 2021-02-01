package components;

import components.matrix.MatrixSizeInputter;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.Main;

public class Controller {
    public MatrixSizeInputter leftMatrixSizeInputter;
    public MatrixSizeInputter rightMatrixSizeInputter;

    public final Main main;
    private final VBox vBox;

    public VBox getVBox() {
        return vBox;
    }

    public Controller(Main main) {
        this.main = main;

        vBox = new VBox();


        vBox.getChildren().addAll(createFirstlayer(), createSecondLater());
    }

    private HBox createSecondLater() {
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(createAdditionButton(), createSubtractionButton(), createMultiplicationButton());

        return hBox;
    }

    private Button createMultiplicationButton() {
        Button button = new Button("Multiplication");
        button.setPrefWidth(100);
        button.setPrefHeight(25);

        return button;
    }

    private Button createSubtractionButton() {
        Button button = new Button("Subtraction");
        button.setPrefWidth(100);
        button.setPrefHeight(25);

        return button;
    }

    private Button createAdditionButton() {
        Button button = new Button("Addition");
        button.setPrefWidth(100);
        button.setPrefHeight(25);

        return button;
    }

    private HBox createFirstlayer() {
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        leftMatrixSizeInputter = new MatrixSizeInputter(main.getLeftMatrixInputter());
        rightMatrixSizeInputter = new MatrixSizeInputter(main.getRightMatrixInputter());

        hBox.getChildren().addAll(leftMatrixSizeInputter.getMainPane(), rightMatrixSizeInputter.getMainPane());

        return hBox;
    }
}
