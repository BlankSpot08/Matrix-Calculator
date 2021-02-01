package components.controller.operations;

import components.matrix.Matrix;
import components.matrix.MatrixInputter;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Subtraction extends Operation {
    public Subtraction(MatrixInputter leftMatrixInputter, MatrixInputter rightMatrixInputter, Matrix matrix, String operation) {
        super(leftMatrixInputter, rightMatrixInputter, matrix, operation);
    }

    @Override
    protected Label[][] mergeMatricesByOperation() {
        Label[][] labels =  new Label[leftMatrixInputter.getTextFields().length][leftMatrixInputter.getTextFields()[0].length];

        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                final int sum = Integer.parseInt(leftMatrixInputter.getTextFields()[i][j].getText()) - Integer.parseInt(rightMatrixInputter.getTextFields()[i][j].getText());
                labels[i][j] = new Label(String.valueOf(sum));
            }

        }

        return labels;
    }

    @Override
    protected boolean matricesValidation() {
        TextField[][] firstMatrixInputter =  leftMatrixInputter.getTextFields();
        TextField[][] secondMatrixInputter =  rightMatrixInputter.getTextFields();

        return firstMatrixInputter.length == secondMatrixInputter.length && firstMatrixInputter[0].length ==  secondMatrixInputter[0].length;
    }
}
