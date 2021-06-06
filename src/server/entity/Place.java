package server.entity;

import java.io.Serial;
import java.io.Serializable;

public class Place implements Serializable {

    @Serial
    private static final long serialVersionUID = 6529685098267757690L;

    private boolean busy;

    public Place() {
        this.busy = false;
    }

    public Place(boolean busy) {
        this.busy = busy;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

}
