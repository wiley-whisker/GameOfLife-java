package common;

import model.GameOfLifeModel;

public interface Controller {
    void addOrganism(int i, int j);
    void removeOrganism(int i, int j);
    void playPause();
    GameOfLifeModel.STATUS getStatus();
}
