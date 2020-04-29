import Interfaces.ITower;
import Rings.*;
import Towers.FinalTower;
import Towers.Tower;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class HanoiTower {
    private Tower towerOne;
    private Tower towerTwo;
    private FinalTower towerThree;
    private Map<Byte, ITower> towers;

    public HanoiTower() {
        this.towerOne = new Tower() {
            {
                AddRing(new TowerRingFive());
                AddRing(new TowerRingFour());
                AddRing(new TowerRingThree());
                AddRing(new TowerRingTwo());
                AddRing(new TowerRingOne());
            }
        };
        this.towerTwo = new Tower();
        this.towerThree = new FinalTower();
        this.towers = new HashMap<Byte, ITower>() {
            {
                put((byte) 1, towerOne);
                put((byte) 2, towerTwo);
                put((byte) 3, towerThree);
            }
        };
    }

    public void RemoveFromAddAt(int source, int target) {
        this.towers.get((byte)target).AddRing(this.towers.get((byte)source).RemoveRing());
    }

    public boolean IsDone() {
        return ((FinalTower) this.towers.get(3)).IsDone();
    }

    public void PrintTowers() {
        this.towers.forEach((towerId, tower) -> {
            System.out.printf(" ============================ Tower %s ========================== \n", towerId);
            tower.PrintTower();
        });
    }
}
