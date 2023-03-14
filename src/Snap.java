import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame {
    public Snap(String name) {
        super(name);
    }

    private int randomIndex;

    private boolean snapRunning;

    public boolean isSnapRunning() {
        return snapRunning;
    }

    public void setSnapRunning(boolean snapRunning) {
        this.snapRunning = snapRunning;
    }

    public int getRandomIndex() {
        return randomIndex;
    }

    public void setRandomIndex() {
        this.randomIndex = (int) (Math.random() * deckOfCards.size());
    }


    public void userTurnInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Press enter to begin!");
        String input = scanner.nextLine();
        if (input.equals("")) {
            System.out.println("Enter key pressed.");
            System.out.println("Let's begin!");
            setSnapRunning(true);
        } else {
            while (!input.isEmpty()) {
                System.out.println("Press enter to begin.");
                input = scanner.nextLine();
                if (input.equals("")) {
                    System.out.println("Enter key pressed.");
                    System.out.println("Let's begin!");
                }
            }
        }
    }

    public void removeCard(Card card){
        deckOfCards.remove(card);
        discardPile.add(card);
    }
    public void snapGame() {
        getDeck();
        shuffleDeck();
        Card firstCard = dealCard();
        System.out.println("Your first card is: " + firstCard.toString());
        shuffleDeck();
        setRandomIndex();
        if (deckOfCards.get(getRandomIndex()).getSymbol() == firstCard.getSymbol()) {
            System.out.println(deckOfCards.get(getRandomIndex()));
            System.out.println("SNAP!");
            System.out.println("Your first card was: " + firstCard);
        } else {
            while (deckOfCards.get(getRandomIndex()).getSymbol() != firstCard.getSymbol()) {
                System.out.println(deckOfCards.get(getRandomIndex()));
                removeCard(deckOfCards.get(getRandomIndex()));
                System.out.println("Let's try again...");
                setRandomIndex();
                if (deckOfCards.get(getRandomIndex()).getSymbol() == firstCard.getSymbol()) {
                    System.out.println(deckOfCards.get(getRandomIndex()));
                    System.out.println("SNAP!");
                    System.out.println("Your first card was: " + firstCard);
                }
            }
        }
    }
}
