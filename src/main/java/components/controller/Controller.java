package components.controller;

import components.controller.operations.Addition;
import components.controller.operations.Multiplication;
import components.controller.operations.Subtraction;
import components.matrix.MatrixSizeInputter;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.Main;

public class Controller {
    public MatrixSizeInputter leftMatrixSizeInputter;
    public MatrixSizeInputter rightMatrixSizeInputter;

    private final Main main;
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

        Button additionButton = createAdditionButton();
        Button subtractionButton = createSubtractionButton();
        Button multiplicationButton = createMultiplicationButton();

        hBox.getChildren().addAll(additionButton, subtractionButton, multiplicationButton);

        return hBox;
    }

    private Button createMultiplicationButton() {
        String multiplicationString = "Multiplication";
        Multiplication multiplication = new Multiplication(main.getLeftMatrixInputter(), main.getRightMatrixInputter(), main.getMatrix(), multiplicationString);

        return multiplication.getButton();
    }

    private Button createSubtractionButton() {
        String subtractionString = "Subtraction";
        Subtraction subtraction = new Subtraction(main.getLeftMatrixInputter(), main.getRightMatrixInputter(), main.getMatrix(), subtractionString);

        return subtraction.getButton();
    }

    private Button createAdditionButton() {
        String additionString = "Addition";
        Addition addition = new Addition(main.getLeftMatrixInputter(), main.getRightMatrixInputter(), main.getMatrix(), additionString);

        return addition.getButton();
    }

    private Pane createFirstlayer() {
//        HBox hBox = new HBox(5);
//        hBox.setAlignment(Pos.CENTER);
//
//        leftMatrixSizeInputter = new MatrixSizeInputter(main.getLeftMatrixInputter());
//        rightMatrixSizeInputter = new MatrixSizeInputter(main.getRightMatrixInputter());
//
//        hBox.getChildren().addAll(leftMatrixSizeInputter.getMainPane(), rightMatrixSizeInputter.getMainPane());
        Inputter inputter = new Inputter(this, main.getLeftMatrixInputter(), main.getRightMatrixInputter());

        return inputter.gethBox();
    }
}
