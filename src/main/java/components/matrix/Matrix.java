package components.matrix;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Matrix extends Pane {
    public final Label[][] labels;

    public Matrix(Label[][] labels) {
        this.labels = labels;
    }

    public final Pane generate() {
        Pane pane = new Pane();

        pane.getChildren().add(createGeneratedGridPane(labels));

        return pane;
    }

    private GridPane createGeneratedGridPane(Label[][] labels) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(2);
        gridPane.setVgap(2);

        final int size = labels.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < labels[i].length; j++) {
                gridPane.add(labels[i][j], i, j);
            }
        }

        return gridPane;
    }
}
