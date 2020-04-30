package Towers;

import Interfaces.ITower;
import Rings.TowerRingBase;

import java.util.Arrays;

public class FinalTower extends Tower {
    private byte[] templateToWin;

    public FinalTower() {
        this.templateToWin = new byte[]{1, 2, 3, 4, 5};
    }

    public boolean IsDone() {
        return Arrays.stream(this.GetTowerRings()).map(ring -> ring.GetRingId()).toArray().equals(this.templateToWin);
    }
}
