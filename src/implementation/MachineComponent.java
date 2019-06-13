package implementation;

import java.util.Observable;

public abstract class MachineComponent extends Observable {
    protected boolean broken = false;

    public void setBroken() {
        broken = false;
    }

    public void repair() {
        broken = false;
    }

    public abstract boolean isBroken();
}
