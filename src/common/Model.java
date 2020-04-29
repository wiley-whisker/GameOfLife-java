package common;

import model.GameOfLifeModel;

public interface Model {
    void addObserver(Observer obs);
    int getDIM();
    void addOrganism(int i, int j);
    void removeOrganism(int i, int j);
    void playPause();
    void setStatus(GameOfLifeModel.STATUS stat);
    GameOfLifeModel.STATUS getStatus();
    boolean[][] getBoard();
}
