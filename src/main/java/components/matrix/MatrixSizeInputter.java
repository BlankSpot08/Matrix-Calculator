package components.matrix;

import com.sun.istack.internal.NotNull;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import util.MatrixUtil;

public class MatrixSizeInputter {
    private final HBox mainPane;

    private TextField columnsTextField;
    private TextField rowsTextField;

    private MatrixInputter matrixInputter;

    public HBox getMainPane() {
        return mainPane;
    }

    public MatrixSizeInputter(@NotNull MatrixInputter matrixInputter) {
        this.matrixInputter = matrixInputter;

        mainPane = new HBox(5);

        Label label = new Label("X");
        label.setAlignment(Pos.CENTER);
        label.setPrefHeight(25);

        mainPane.getChildren().addAll(createRowTextField(), label, createColumnTextField());
    }

    private TextField createRowTextField() {
        rowsTextField = new TextField("3");
        rowsTextField.setStyle("-fx-alignment: center");
        rowsTextField.setPrefWidth(50);
        rowsTextField.setPrefHeight(25);

        rowsTextField.setOnKeyReleased(e -> {
            if (e.getCode().isDigitKey()) {
                final int newRow = Integer.parseInt(rowsTextField.getText());
                TextField[][] textFields = MatrixUtil.createMatrixTextFields(matrixInputter.getTextFields().length, newRow);

                final TextField[][] temp = matrixInputter.getTextFields();

                textFields = newTextFieldArrayWithRows(textFields, temp);

                matrixInputter.setTextFields(textFields);
                matrixInputter.clearGridPane();
                matrixInputter.updateGridPane();
            }
        });

        return rowsTextField;
    }

    private TextField[][] newTextFieldArrayWithRows(TextField[][] textFields, TextField[][] temp) {
        if (textFields[0].length >= temp[0].length) {
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[i].length; j++) {
                    textFields[i][j] = temp[i][j];
                }
            }
        } else {
            for (int i = 0; i < textFields.length; i++) {
                for (int j = 0; j < textFields[i].length; j++) {
                    textFields[i][j] = temp[i][j];
                }
            }
        }

        return textFields;
    }

    private TextField createColumnTextField() {
        columnsTextField = new TextField("3");
        columnsTextField.setStyle("-fx-alignment: center");
        columnsTextField.setPrefWidth(50);

        columnsTextField.setOnKeyReleased(e -> {
            if (e.getCode().isDigitKey()) {
                final int newColumn = Integer.parseInt(columnsTextField.getText());
                TextField[][] textFields = MatrixUtil.createMatrixTextFields(newColumn, matrixInputter.getTextFields()[0].length);

                final TextField[][] temp = matrixInputter.getTextFields();

                textFields = newTextFieldArrayWithColumns(textFields, temp);

                matrixInputter.setTextFields(textFields);
                matrixInputter.clearGridPane();
                matrixInputter.updateGridPane();
            }
        });

        return columnsTextField;
    }

    private TextField[][] newTextFieldArrayWithColumns(TextField[][] textFields, TextField[][] temp) {
        if (textFields.length >= temp.length) {
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[i].length; j++) {
                    textFields[i][j] = temp[i][j];
                }
            }
        } else {
            for (int i = 0; i < textFields.length; i++) {
                for (int j = 0; j < textFields[i].length; j++) {
                    textFields[i][j] = temp[i][j];
                }
            }
        }

        return textFields;
    }
}
