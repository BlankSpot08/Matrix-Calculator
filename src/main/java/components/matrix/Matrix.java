package components.matrix;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Matrix {
    private Label[][] labels;
    private GridPane gridPane;
    private final Pane pane;

    public void setLabels(Label[][] labels) {
        this.labels = labels;
    }

    public final Pane getPane() {
        return pane;
    }

    public Matrix(Label[][] labels) {
        this.labels = labels;
        pane = new Pane();

        GridPane gridPane = createGeneratedGridPane(labels);
        pane.getChildren().add(gridPane);
    }

    private GridPane createGeneratedGridPane(Label[][] labels) {
        gridPane = new GridPane();
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

    public void clearGridPane() {
        gridPane.getChildren().clear();
    }

    public void updateGridPane() {
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j <  labels[i].length; j++) {
                labels[i][j].setPrefWidth(50);
                labels[i][j].setPrefHeight(50);
                labels[i][j].setStyle("-fx-alignment: center");

                gridPane.add(labels[i][j], i, j);
            }
        }
    }
}
