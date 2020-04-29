package common;

import model.CellUpdate;

public interface Observer {
    void update(CellUpdate update);
}
