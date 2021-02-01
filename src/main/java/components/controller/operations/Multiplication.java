package components.controller.operations;

import components.matrix.Matrix;
import components.matrix.MatrixInputter;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Multiplication extends Operation {
    public Multiplication(MatrixInputter leftMatrixInputter, MatrixInputter rightMatrixInputter, Matrix matrix, String operation) {
        super(leftMatrixInputter, rightMatrixInputter, matrix, operation);
    }

    @Override
    protected Label[][] mergeMatricesByOperation() {
        final int column = leftMatrixInputter.getTextFields()[0].length;
        final int row = rightMatrixInputter.getTextFields().length;

        Label[][] labels = new Label[row][column];

        for (int i = 0; i < leftMatrixInputter.getTextFields()[0].length; i++) {
            for (int j = 0; j < rightMatrixInputter.getTextFields().length; j++) {
                int temp = 0;

                for (int k = 0; k < rightMatrixInputter.getTextFields()[0].length; k++) {
                    int firstNumber = Integer.parseInt(leftMatrixInputter.getTextFields()[k][i].getText());
                    int secondNumber = Integer.parseInt(rightMatrixInputter.getTextFields()[j][k].getText());
                    int product =  firstNumber * secondNumber;

                    temp += product;
                }

                labels[j][i] = new Label(String.valueOf(temp));
            }
        }

        return labels;
    }

    @Override
    protected boolean matricesValidation() {
        TextField[][] firstTextField = leftMatrixInputter.getTextFields();
        TextField[][] secondTextField = rightMatrixInputter.getTextFields();

        return firstTextField.length == secondTextField[0].length;
    }
}
