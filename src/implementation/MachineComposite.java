package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MachineComposite extends MachineComponent implements Observer {
    private List<MachineComponent> components = new ArrayList<>();
    private int brokenComponents = 0;

    public void addComponent(MachineComponent mc) {
        components.add(mc);
        mc.addObserver(this);
        if (mc.isBroken()) brokenComponents += 1;
        if (!isBroken && brokenComponents == 1) notifyChanges();
    }

    public boolean isBroken() {
        return isBroken || brokenComponents > 0;
    }

    public void update(Observable obs, Object arg) {
        MachineComponent mc = (MachineComponent) obs;
        if (mc.isBroken()) {
            brokenSubcomponent();
        } else {
            repairedSubcomponent(mc);
        }
    }

    private void brokenSubcomponent() {
        boolean wasBroken = isBroken();
        brokenComponents += 1;
        if (!wasBroken) {
            notifyChanges();
        }
    }

    private void repairedSubcomponent(MachineComponent mc) {
        brokenComponents -= 1;
        if(brokenComponents == 0) isBroken = false;
        if (!isBroken()) {
            notifyChanges();
        }
    }
}
