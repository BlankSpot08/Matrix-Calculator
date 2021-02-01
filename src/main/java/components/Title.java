package components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Title {
    private final Pane pane;

    public Pane getPane() {
        return pane;
    }

    public Title(String title) {
        Label titleLabel = new Label(title);

        pane = createMainPane(titleLabel);
    }

    private Pane createMainPane(Label titleLabel) {
        Pane pane = new Pane();

        pane.getChildren().add(titleLabel);

        titleLabel.prefWidthProperty().bind(pane.widthProperty());
        titleLabel.setAlignment(Pos.CENTER);

        return pane;
    }
}
