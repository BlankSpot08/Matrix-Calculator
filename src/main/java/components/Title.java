package components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;

public class Title {
    public Pane mainPane;
    private Label titleLabel;

    public Title(String title) {
        titleLabel = new Label(title);
    }

    public Pane generate() {
        mainPane = new Pane();

        mainPane.getChildren().add(titleLabel);

        titleLabel.prefWidthProperty().bind(mainPane.widthProperty());
        titleLabel.setAlignment(Pos.CENTER);

        return mainPane;
    }
}
