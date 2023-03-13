import java.util.ArrayList;

public class CardGame {
    public static ArrayList<Card> deckOfCards = new ArrayList<Card>(52);
    private String name;

    public CardGame(String name) {
        this.name = name;
    }

    public ArrayList<Card> getDeck() {
        String[] suit = {"♣", "♠", "♦", "♥"};
        String[] symbol = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        int[] values = {1,13, 12, 11, 10,9,8,7,6,5,4,3,2};
        int count = 0;
        for (int i = 0; i < symbol.length; i++){
            for (int index=0; index < suit.length; index++){
                Card card = new Card(symbol[i], suit[index], values[i]);
                deckOfCards.add(count,card);
                count++;
            }
        }
        return deckOfCards;
    }


}

