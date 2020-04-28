package common;

import model.LifeUpdate;

public interface Observer {
    void update(LifeUpdate update);
}
