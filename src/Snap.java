import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame {
    public Snap(String name) {
        super(name);
    }

    private int randomIndex;

    private boolean correctInput;

    public boolean isCorrectInput() {
        return correctInput;
    }

    public void setCorrectInput(boolean correctInput) {
        this.correctInput = correctInput;
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
            setCorrectInput(true);
        } else {
            while (!input.isEmpty()) {
                System.out.println("Press enter to begin.");
                input = scanner.nextLine();
                if (input.equals("")) {
                    System.out.println("Enter key pressed.");
                    System.out.println("Let's begin!");
                    setCorrectInput(true);

                }
            }
        }
    }

    public void userInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press enter");
        String inputString  = input.nextLine();
        if (inputString.equals("")) {
            setCorrectInput(true);
        } while (!inputString.isEmpty()) {
            System.out.println("Press enter to begin.");
            inputString = input.nextLine();
            if (input.equals("")) {
                setCorrectInput(true);

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
        if (deckOfCards.get(getRandomIndex()).getSymbol() == firstCard.getSymbol() && isCorrectInput()) {
            System.out.println(deckOfCards.get(getRandomIndex()));
            System.out.println("SNAP!");
            System.out.println("Your first card was: " + firstCard);
        } else {
            while (deckOfCards.get(getRandomIndex()).getSymbol() != firstCard.getSymbol() && isCorrectInput()) {
                userInput();
                System.out.println(deckOfCards.get(getRandomIndex()));
                removeCard(deckOfCards.get(getRandomIndex()));
                System.out.println("Let's try again...");
                setRandomIndex();
                if (deckOfCards.get(getRandomIndex()).getSymbol() == firstCard.getSymbol() && isCorrectInput()) {
                    System.out.println(deckOfCards.get(getRandomIndex()));
                    System.out.println("SNAP!");
                    System.out.println("Your first card was: " + firstCard);
                }
            }
        }
    }
}
