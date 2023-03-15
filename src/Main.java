public class Main {
    public static void main(String[] args) {

        Snap game = new Snap("snap");
        game.getDeck();
        game.userTurnInput();
        game.snapGame();
        System.out.println(game.discardPile);



    }
}