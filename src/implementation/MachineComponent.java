package implementation;

import java.util.Observable;

public abstract class MachineComponent extends Observable {
    protected boolean isBroken = false;

    public void setBroken() {
        boolean wasBroken = isBroken();
        isBroken = true;
        if (!wasBroken) {
            notifyChanges();
        }
    }

    public void repair() {
        boolean wasBroken = isBroken();
        isBroken = false;
        if (!wasBroken) {
            notifyChanges();
        }
    }

    public abstract boolean isBroken();

    protected void notifyChanges() {
        setChanged();
        notifyObservers();
    }
}
