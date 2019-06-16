package implementation;

import java.util.Observable;

public abstract class MachineComponent extends Observable {
    protected boolean broken = false;

    public void setBroken() {
        boolean wasBroken = isBroken();
        broken = true;
        if (!wasBroken) {
            notifyChanges();
        }
    }

    public void repair() {
        boolean wasBroken = isBroken();
        broken = false;
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
