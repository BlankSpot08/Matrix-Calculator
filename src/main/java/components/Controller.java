package components;

import components.matrix.MatrixSizeInputter;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import main.Main;

public class Controller {
    public MatrixSizeInputter leftMatrixSizeInputter;
    public MatrixSizeInputter rightMatrixSizeInputter;

    public final Main main;

    public Controller(Main main) {
        this.main = main;
    }

    public VBox generate() {
//        HBox centerHBox = new HBox(2);
//
//        Button additionButton = new Button("Addition");
//        Button subtractionButton = new Button("Subtraction");
//        Button multiplicationButton = new Button("Multiplication");
//
//        HBox internalRightHbox = new HBox();
//        internalRightHbox.setAlignment(Pos.CENTER_RIGHT);
//        HBox.setHgrow(internalRightHbox, Priority.ALWAYS);
//
//        Button solveButton = new Button("Solve");
//
//        Matrix matrix = new Matrix();
//        HBox test = matrix.generateMatrixXInputter();
//
//        internalRightHbox.getChildren().addAll(test, solveButton);
//
//        centerHBox.getChildren().addAll(additionButton, subtractionButton, multiplicationButton,  internalRightHbox);
        VBox vBox = new VBox();

        vBox.getChildren().add(createFirstlayer());

        return vBox;
    }

    private HBox createFirstlayer() {
        HBox hBox = new HBox();

        leftMatrixSizeInputter = new MatrixSizeInputter(this);

        hBox.getChildren().addAll(leftMatrixSizeInputter.generate());

        return hBox;
    }
}
