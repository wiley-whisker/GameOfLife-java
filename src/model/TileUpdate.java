package model;

public class TileUpdate {
    private final int i;
    private final int j;
    private final boolean hasOrg;

    public TileUpdate(boolean hasOrg, int i, int j) {
        this.hasOrg = hasOrg;
        this.i = i;
        this.j = j;
    }

    public boolean hasOrganism() {
        return hasOrg;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
