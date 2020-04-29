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

    public OrganismButton(int i, int j, int DIM, Controller controller) {
        super();
        this.hasOrg = false;
        this.i = i;
        this.j = j;
        this.controller = controller;
        this.setBackground(BLACK);
        setMinSize((double)GameOfLifeGUI.WINDOW_DIM/DIM, (double)GameOfLifeGUI.WINDOW_DIM/DIM);
        setOrganism(hasOrg);
    }

    public void setOrganism(boolean hasOrg) {
        this.hasOrg = hasOrg;
        if (hasOrg) {
            setOnAction((event) -> {
                System.out.println("ya boi " + i + j + " here");
                controller.removeOrganism(i,j);
            });
            setBackground(WHITE);
        } else {
            setOnAction((event) -> {
                System.out.println("ya boi " + i + j + " here");
                controller.addOrganism(i,j);
            });
            setBackground(BLACK);
        }
    }
}
