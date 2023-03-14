public class Main {
    public static void main(String[] args) {

        Snap game = new Snap("snap");
        game.getDeck();
        game.userTurnInput();
        System.out.println(game.discardPile);
        game.snapGame();
        System.out.println(game.discardPile);



    }
}