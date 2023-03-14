import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CardGame {
    public static ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private String name;
    public static ArrayList<Card> discardPile = new ArrayList<Card>();


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
                Card card = new Card(suit[index],symbol[i] , values[i]);
                deckOfCards.add(count,card);
                count++;
            }
        }
        return deckOfCards;
    }

    public Card dealCard(){
        Card top = deckOfCards.get(0);
        discardPile.add(top);
        deckOfCards.remove(0);
        return top;
    }

    public ArrayList<Card> sortDeckInNumberOrder(){
        Collections.sort(deckOfCards, Comparator.comparing(Card::getValue));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits(){
        Collections.sort(deckOfCards, Comparator.comparing(Card::getSuit));
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

}

