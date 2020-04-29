package model;

import java.util.LinkedList;
import java.util.List;

public class LifeUpdate {
    private List<CellUpdate> updates;

    public LifeUpdate() {
        updates = new LinkedList<CellUpdate>();
    }

    public void addUpdate(boolean hasOrg, int i, int j) {
        updates.add(new CellUpdate(hasOrg, i, j));
    }

    public List<CellUpdate> getUpdates() {
        return updates;
    }
}
