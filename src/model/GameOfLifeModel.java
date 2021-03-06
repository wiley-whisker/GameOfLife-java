package model;

import common.Model;
import common.Observer;
import controller.ControllerThread;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeModel implements Model {

    public enum STATUS {
        PLAY,
        PAUSE
    }

    private int DIM;
    private List<Observer> observers;
    private boolean[][] board;
    private STATUS status;

    public GameOfLifeModel(int DIM) {
        this.DIM = DIM;
        this.observers = new ArrayList<Observer>();
        this.board = new boolean[DIM][DIM];
        this.status = STATUS.PAUSE;
    }

    @Override
    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }

    private void updateObservers(CellUpdate update) {
        for (Observer o : this.observers) {
            o.update(update);
        }
    }

    @Override
    public int getDIM() {
        return this.DIM;
    }

    @Override
    public STATUS getStatus() {
        return status;
    }

    @Override
    public boolean[][] getBoard() {
        return board;
    }

    @Override
    public void addOrganism(int i, int j) {
        if (!board[i][j]) {
            // do something
            board[i][j] = true;
            updateObservers(new CellUpdate(true, i, j));
        }
    }

    @Override
    public void removeOrganism(int i, int j) {
        if (board[i][j]) {
            // do something
            board[i][j] = false;
            updateObservers(new CellUpdate(false, i, j));
        }
    }

    @Override
    public void playPause() {

    }

    @Override
    public void setStatus(STATUS status) {
        this.status = status;
        updateObservers(null);
    }
}
