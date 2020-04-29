package Towers;

import Interfaces.ITower;
import Rings.TowerRingBase;

import java.util.Stack;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Tower implements ITower {
    private Stack<TowerRingBase> rings;

    public Tower() {
        this.rings = new Stack<>();
    }

    @Override
    public void AddRing(TowerRingBase ring) {
        this.rings.push(ring);
    }

    @Override
    public TowerRingBase RemoveRing() {
        return this.rings.pop();
    }

    @Override
    public TowerRingBase[] GetTowerRings() {
        return (TowerRingBase[]) this.rings.toArray();
    }

    @Override
    public void PrintTower() {
        for (int i = this.rings.size() - 1; i >= 0 ; i--) {
            System.out.println("||" + this.rings.elementAt(i).toString());
        }
    }


}
