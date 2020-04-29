package Interfaces;

import Rings.TowerRingBase;

public interface ITower {
    void AddRing(TowerRingBase ring);
    TowerRingBase RemoveRing();
    TowerRingBase[] GetTowerRings();
    void PrintTower();
}
