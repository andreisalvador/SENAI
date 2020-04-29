public class Main {

    public static void main(String[] args) {
        HanoiTower game = new HanoiTower();


        game.PrintTowers();
        game.RemoveFromAddAt(1, 3);
        game.PrintTowers();
        game.RemoveFromAddAt(1, 2);
        game.PrintTowers();
        game.RemoveFromAddAt(3, 1);
        game.PrintTowers();
        game.RemoveFromAddAt(1, 3);
        game.RemoveFromAddAt(1, 3);
        game.RemoveFromAddAt(1, 3);
        game.PrintTowers();
    }
}
