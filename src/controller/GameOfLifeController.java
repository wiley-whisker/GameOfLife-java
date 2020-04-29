package controller;

import common.Controller;
import common.Model;
import model.GameOfLifeModel;
import model.GameOfLifeModel.STATUS;

public class GameOfLifeController implements Controller {

    private Model model;
    private STATUS status;

    public GameOfLifeController(Model model) {
        this.model = model;
        this.status = STATUS.PAUSE;
    }

    @Override
    public void addOrganism(int i, int j) {
        if (status == STATUS.PAUSE) {
            model.addOrganism(i,j);
        }
    }

    @Override
    public void removeOrganism(int i, int j) {
        if (status == STATUS.PAUSE) {
            model.removeOrganism(i,j);
        }
    }

    @Override
    public void playPause() {
        if (status == STATUS.PLAY) {
            // stop running
            status = STATUS.PAUSE;
        } else {
            // start running
            status = STATUS.PLAY;
        }
        model.setStatus(status);
    }
}
