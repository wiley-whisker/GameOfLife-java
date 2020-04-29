package view.gui;

import common.Controller;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayButton extends Button {

    public PlayButton(Controller controller) {
        //setGraphic(new ImageView(new Image(getClass().getResourceAsStream("assets/pokeball.png"))));
        setText("Play/pause");
        setOnAction((event) ->  {
            controller.playPause();
        });
    }
}
