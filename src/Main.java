public class Main {
    public static void main(String[] args) {

        Snap game = new Snap("snap");
        game.getDeck();
        game.userStartInput();
        game.snapSingleGame();
        game.countDiscard();



    }
}