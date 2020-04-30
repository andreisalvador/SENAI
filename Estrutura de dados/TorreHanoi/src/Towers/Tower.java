package Towers;

import Interfaces.ITower;
import Rings.TowerRingBase;

import java.util.Stack;

public class Tower implements ITower {
    public static final int RINGS_QUANTITY = 5;
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
        for (int i = this.rings.size() - 1; i >= 0; i--) {
            String spaces = " ".repeat(RINGS_QUANTITY - this.rings.elementAt(i).GetRingId());

            System.out.println(spaces + this.rings.elementAt(i).toString() + "||" + this.rings.elementAt(i).toString());
        }
    }


}
