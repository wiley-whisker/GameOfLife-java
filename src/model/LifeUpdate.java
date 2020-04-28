package model;

import java.util.LinkedList;
import java.util.List;

public class LifeUpdate {
    private List<TileUpdate> updates;

    public LifeUpdate() {
        updates = new LinkedList<TileUpdate>();
    }

    public void addUpdate(boolean hasOrg, int i, int j) {
        updates.add(new TileUpdate(hasOrg, i, j));
    }

    public List<TileUpdate> getUpdates() {
        return updates;
    }
}
