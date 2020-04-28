package view.gui;

import common.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class OrganismButton extends Button {
    private static final Background WHITE =
            new Background(new BackgroundFill(Color.WHITE, null, null));

    private static final Background BLACK =
            new Background(new BackgroundFill(Color.BLACK, null, null));
    private boolean hasOrg;
    private int i;
    private int j;
    private Controller controller;

    public OrganismButton(int i, int j, Controller controller) {
        super();
        this.hasOrg = false;
        this.i = i;
        this.j = j;
        this.controller = controller;
        this.setBackground(BLACK);
        setMinSize(50, 50);
        setOnAction((event) -> {
            System.out.println("ya boi " + i + j + " here");
            setOrganism(!hasOrg);
        });
    }

    public void setOrganism(boolean hasOrg) {
        this.hasOrg = hasOrg;
        if (hasOrg) {
            setBackground(WHITE);
        } else {
            setBackground(BLACK);
        }
    }
}
