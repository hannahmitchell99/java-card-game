public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CardGame first = new CardGame("GameOne");
        System.out.println(first.getDeck().size());
        System.out.println(first.deckOfCards);

    }
}