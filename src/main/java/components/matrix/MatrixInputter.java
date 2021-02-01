package components.matrix;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MatrixInputter {
    private final GridPane gridPane;
    private TextField[][] textFields;

    public final void setTextFields(TextField[][] textFields) {
        this.textFields = textFields;
    }

    public final TextField[][] getTextFields() {
        return textFields;
    }

    public final GridPane getGridPane() {
        return gridPane;
    }

    public MatrixInputter(TextField[][] textFields) {
        this.textFields = textFields;

        gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        final int size = textFields.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
//                textFields[i][j].setText(String.valueOf(j));
                textFields[i][j].setText(textFields[i][j].getText());
                gridPane.add(textFields[i][j], i, j);
            }
        }
    }

    public final void updateGridPane() {
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                gridPane.add(textFields[i][j], i, j);
            }
        }
    }

    public final void clearGridPane() {
        gridPane.getChildren().clear();
    }
}
