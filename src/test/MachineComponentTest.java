package test;

import org.junit.jupiter.api.*;
import implementation.*;

import static org.junit.jupiter.api.Assertions.*;

public class MachineComponentTest {
    MachineComponent mc1;
    MachineComponent mc2;
    MachineComponent mc3;
    MachineComponent mc4;

    @BeforeEach
    public void setUp() {
        mc1 = new MachineComposite();
        mc2 = new MachineComposite();
        mc3 = new Machine();
        mc4 = new Machine();
    }

    @Test
    public void machineTest() {
        assertFalse(mc3.isBroken());
        mc3.setBroken();
        assertTrue(mc3.isBroken());
        mc3.repair();
        assertFalse(mc3.isBroken());
    }

    @Test
    public void machineCompositeTest() {
        ((MachineComposite) mc1).addComponent(mc2);
        ((MachineComposite) mc2).addComponent(mc4);
        ((MachineComposite) mc1).addComponent(mc3);

        assertFalse(mc1.isBroken());
        mc3.setBroken();
        assertTrue(mc1.isBroken());
        mc4.setBroken();
        mc3.repair();
        assertTrue(mc1.isBroken());
        mc4.repair();
        assertFalse(mc2.isBroken());
        assertFalse(mc1.isBroken());
    }
}
