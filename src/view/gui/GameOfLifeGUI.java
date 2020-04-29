package view.gui;

import common.Controller;
import controller.GameOfLifeController;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.GameOfLifeModel;
import model.LifeUpdate;
import common.Model;
import common.Observer;
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.List;

public class GameOfLifeGUI extends Application implements Observer {

    public static final int WINDOW_DIM = 600;
    public static final String PLAY_BTN = "/home/wiley/java_projects/GameOfLife/src/view/gui/assets/pokeball.png";

    private Controller controller;
    private Model model;
    private GridPane grid;
    private InfoArea infoArea;
    private OrganismButton[][] buttons;
    private Label statusLabel;

    @Override
    public void init() {
        List<String> args = getParameters().getRaw();
        this.model = new GameOfLifeModel(Integer.parseInt(args.get(0)));
        this.model.addObserver(this);
        this.controller = new GameOfLifeController(model);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.buttons = new OrganismButton[model.getDIM()][model.getDIM()];
        this.grid = new GridPane();
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new OrganismButton(i, j, model.getDIM(), this.controller);
                grid.add(buttons[i][j], j, i);
            }
        }

        PlayButton pb = new PlayButton(controller);
        statusLabel = new Label(model.getStatus().toString());
        HBox hb = new HBox();
        hb.getChildren().addAll(pb, statusLabel);

        BorderPane bp = new BorderPane();
        bp.setCenter(grid);
        bp.setTop(hb);
        Scene scene = new Scene(bp, WINDOW_DIM, WINDOW_DIM);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void updateStatus() {
        statusLabel.setText(model.getStatus().toString());
    }

    private void _update(LifeUpdate update) {
        if (update != null) {
            // do board stuff
        }
        updateStatus();
    }

    @Override
    public void update(LifeUpdate update) {
        Platform.runLater(() -> {
            _update(update);
        });
    }

    @Override
    public void stop() {
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java GameOfLifeGUI DIM");
            System.exit(-1);
        } else {
            launch(args);
        }
    }
}
