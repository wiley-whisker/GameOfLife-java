package controller;

import common.Controller;
import common.Model;
import model.GameOfLifeModel;

import java.util.Arrays;

public class ControllerThread extends Thread {

    private Model model;
    private Controller controller;

    public ControllerThread(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
    }

    public boolean[][] deepCopy(boolean[][] old) {
        boolean[][] new_arr = new boolean[old.length][old[0].length];
        for (int i = 0; i < old.length; i++) {
            for (int j = 0; j < old[0].length; j++) {
                new_arr[i][j] = old[i][j];
            }
        }
        return new_arr;
    }

    public static int wrapCoord(int n, int DIM) {
        if (0 <= n) {
            return n % DIM;
        } else {
            return DIM + n;
        }
    }

    private void rules(int I, int J, boolean[][] s_board) {
        int DIM = s_board.length;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s_board[wrapCoord(I-1+i, DIM)][wrapCoord(J-1+j, DIM)]) {
                    count++;
                }
            }
        }
        if (s_board[I][J]) {
            count--; // don't count self
            if (count < 2) {
                model.removeOrganism(I,J);
            } else if (count == 2 || count == 3) {
                model.addOrganism(I,J);
            } else {
                model.removeOrganism(I,J);
            }
        } else {
            if (count == 3) {
                model.addOrganism(I,J);
            }
        }
    }

    @Override
    public void run() {
        while (controller.getStatus() == GameOfLifeModel.STATUS.PLAY) {
            int DIM = model.getDIM();
            final boolean[][] start_board = deepCopy(model.getBoard());
            for (int i = 0; i < DIM; i++) {
                for (int j = 0; j < DIM; j++) {
                    rules(i,j, start_board);
                }
            }
            try {//replac w/ https://stackoverflow.com/questions/54394042/java-how-to-avoid-using-thread-sleep-in-a-loop
                sleep(1000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
