package view.gui;

import common.Controller;
import controller.GameOfLifeController;
import javafx.scene.Scene;
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

    private Controller controller;
    private Model model;
    private GridPane grid;
    private InfoArea infoArea;
    private OrganismButton[][] buttons;

    @Override
    public void init() {
        List<String> args = getParameters().getRaw();
        this.model = new GameOfLifeModel(Integer.parseInt(args.get(0)));
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
        Scene scene = new Scene(grid, WINDOW_DIM, WINDOW_DIM);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void update(LifeUpdate update) {

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
