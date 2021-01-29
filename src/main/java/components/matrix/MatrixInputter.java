package components.matrix;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MatrixInputter extends Pane {
    private GridPane gridPane;
    public TextField[][] textFields;

    public final int getColumns() {
        return textFields[0].length;
    }

    public final int getRows() {
        return textFields.length;
    }

    public MatrixInputter(TextField[][] textFields) {
        this.textFields = textFields;
    }

    public final GridPane generate() {
        gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);

        final int size = textFields.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                textFields[i][j].setText(textFields[i][j].getText());
                gridPane.add(textFields[i][j], j, i);
            }
        }

        return gridPane;
    }
}
