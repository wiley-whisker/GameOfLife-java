package model;

import common.Model;
import common.Observer;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeModel implements Model {

    private int DIM;
    private List<Observer> observers;
    private boolean[][] board;

    public GameOfLifeModel(int DIM) {
        this.DIM = DIM;
        this.observers = new ArrayList<Observer>();
        this.board = new boolean[DIM][DIM];
    }

    @Override
    public void addObserver(Observer obs) {
        this.observers.add(obs);
    }

    private void updateObservers(LifeUpdate update) {
        for (Observer o : this.observers) {
            o.update(update);
        }
    }

    @Override
    public int getDIM() {
        return this.DIM;
    }

    @Override
    public void addOrganism(int i, int j) {

    }

    @Override
    public void removeOrganism(int i, int j) {

    }

    @Override
    public void playPause() {

    }
}
