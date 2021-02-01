package components.controller.operations;

import components.matrix.Matrix;
import components.matrix.MatrixInputter;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public abstract class Operation {
    protected final MatrixInputter leftMatrixInputter;
    protected final MatrixInputter rightMatrixInputter;
    protected final Matrix matrix;

    private final Button button;

    public Button getButton() {
        return button;
    }

    public Operation(MatrixInputter leftMatrixInputter, MatrixInputter rightMatrixInputter, Matrix matrix, String operation) {
        this.leftMatrixInputter = leftMatrixInputter;
        this.rightMatrixInputter = rightMatrixInputter;
        this.matrix = matrix;

        button = new Button(operation);
        button.setPrefWidth(100);

        button.setOnAction(e -> {
            if (matricesValidation()) {
                matrix.clearGridPane();
                matrix.setLabels(operate());
                matrix.updateGridPane();
            }
        });
    }

    private final Label[][] operate() {
        Label[][] label = mergeMatricesByOperation();

        return label;
    }

    protected abstract Label[][] mergeMatricesByOperation();
    protected abstract boolean matricesValidation();
}
