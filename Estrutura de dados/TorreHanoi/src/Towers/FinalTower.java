package Towers;

import Interfaces.ITower;
import Rings.TowerRingBase;

import java.util.Arrays;

public class FinalTower implements ITower {
    private ITower tower = new Tower();
    private byte[] templateToWin;

    public FinalTower() {
        this.templateToWin = new byte[]{1, 2, 3, 4, 5};
    }

    @Override
    public void AddRing(TowerRingBase ring) {
        this.tower.AddRing(ring);
    }

    @Override
    public TowerRingBase RemoveRing() {
        return this.tower.RemoveRing();
    }

    @Override
    public TowerRingBase[] GetTowerRings() {
        return this.tower.GetTowerRings();
    }

    @Override
    public void PrintTower() {
        this.tower.PrintTower();
    }

    public boolean IsDone() {
        return Arrays.stream(this.tower.GetTowerRings()).map(ring -> ring.GetRingId()).toArray().equals(this.templateToWin);
    }
}
