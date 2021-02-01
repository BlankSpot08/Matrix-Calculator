package components.controller;

import components.matrix.MatrixInputter;
import components.matrix.MatrixSizeInputter;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class Inputter {
    private final HBox hBox;

    public HBox gethBox() {
        return hBox;
    }

    public Inputter(Controller controller, MatrixInputter leftMatrixInputter, MatrixInputter rightMatrixInputter) {
        hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        controller.leftMatrixSizeInputter = new MatrixSizeInputter(leftMatrixInputter);
        controller.rightMatrixSizeInputter = new MatrixSizeInputter(rightMatrixInputter);

        hBox.getChildren().addAll(controller.leftMatrixSizeInputter.getMainPane(), controller.rightMatrixSizeInputter.getMainPane());
    }
}
