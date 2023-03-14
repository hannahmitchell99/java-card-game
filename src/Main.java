public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CardGame first = new CardGame("GameOne");
        System.out.println(first.getDeck().size());
        System.out.println(first.deckOfCards);

        System.out.println(first.dealCard());
        System.out.println(first.sortDeckInNumberOrder());
        System.out.println(first.sortDeckIntoSuits());
        System.out.println(first.shuffleDeck());

    }
}