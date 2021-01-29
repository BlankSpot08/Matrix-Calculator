package components.matrix;

import components.Controller;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MatrixSizeInputter extends Pane {
    public TextField columnsTextField;
    public TextField rowsTextField;

    private final Controller controller;

    public MatrixSizeInputter(Controller controller) {
        this.controller = controller;
    }

    public final HBox generate() {
        HBox hBox = new HBox(3);

        Label label = new Label("X");
        label.setAlignment(Pos.CENTER);

        hBox.getChildren().addAll(createColumnTextField(), label, createRowTextField());

        return hBox;
    }

    private TextField createRowTextField() {
        rowsTextField = new TextField("3");
        rowsTextField.setStyle("-fx-alignment: center");
        rowsTextField.setPrefWidth(50);

        rowsTextField.setOnKeyReleased(e -> {
            if (e.getCode().isDigitKey()) {
                final int newRow = Integer.parseInt(rowsTextField.getText());
                TextField[][] textFields = controller.main.createMatrixTextFields(controller.main.leftMatrixInputter.textFields.length, newRow);

                final TextField[][] temp = controller.main.leftMatrixInputter.textFields;

                textFields = convertTextFieldArray(textFields, temp, newRow);

                controller.main.centerHBox.getChildren().remove(0);

                controller.main.leftMatrixInputter = new MatrixInputter(textFields);

                controller.main.leftMatrixInputter.textFields = textFields;
                controller.main.centerHBox.getChildren().add(0, controller.main.leftMatrixInputter.generate());
            }
        });

        return rowsTextField;
    }

    private TextField createColumnTextField() {
        columnsTextField = new TextField("3");
        columnsTextField.setStyle("-fx-alignment: center");
        columnsTextField.setPrefWidth(50);

        columnsTextField.setOnKeyReleased(e -> {
            if (e.getCode().isDigitKey()) {
                final int newColumn = Integer.parseInt(columnsTextField.getText());
                TextField[][] textFields = controller.main.createMatrixTextFields(newColumn, controller.main.leftMatrixInputter.textFields[0].length);

                final TextField[][] temp = controller.main.leftMatrixInputter.textFields;

                textFields = convertTextFieldArray(textFields, temp, newColumn);

                controller.main.centerHBox.getChildren().remove(0);

                controller.main.leftMatrixInputter = new MatrixInputter(textFields);

                controller.main.leftMatrixInputter.textFields = textFields;
                controller.main.centerHBox.getChildren().add(0, controller.main.leftMatrixInputter.generate());
            }

//            columnsTextField.setText(columnsTextField.getText().replaceAll("[^\\d]", ""));
        });

        return columnsTextField;
    }

    private TextField[][] convertTextFieldArray(TextField[][] textFields, TextField[][] temp, int newThing) {
        if (newThing >= temp.length) {
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

    public String matrixToString(TextField[][] textFields) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                stringBuilder.append(textFields[i][j].getText()).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
