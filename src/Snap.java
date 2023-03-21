import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Snap extends CardGame {
    public Snap(String name) {
        super(name);
    }

    private int randomIndex;

    private boolean correctInput;

    private String lastCardSymbol;
    private ArrayList<Card> player1Stack = new ArrayList<Card>();
    private ArrayList<Card> player2Stack = new ArrayList<Card>();

    public ArrayList<Card> getPlayer1Stack() {
        return player1Stack;
    }

    public ArrayList<Card> getPlayer2Stack() {
        return player2Stack;
    }

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
        this.randomIndex = (int) (Math.random() * getDeckOfCards().size());
    }

    public void userStartInput() {
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

    public void userTurnInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Press enter for a new card");
        String inputString = input.nextLine();
        if (inputString.equals("")) {
            setCorrectInput(true);
        }
        while (!inputString.isEmpty()) {
            System.out.println("Press enter to begin.");
            inputString = input.nextLine();
            if (input.equals("")) {
                setCorrectInput(true);

            }
        }
    }

    public void removeCard(Card card) {
        getDeckOfCards().remove(card);
        getDiscardPile().add(card);
    }

    public void countDiscard(){
        System.out.println("It took "+getDiscardPile().size()+ " cards to get to the right card!");
    }

    public void gameRunning(){

        while (getDeckOfCards().get(getRandomIndex()).getSymbol() != lastCardSymbol && isCorrectInput()) {
            userTurnInput();
            System.out.println(getDeckOfCards().get(getRandomIndex()));
            this.lastCardSymbol = getDeckOfCards().get(getRandomIndex()).getSymbol();
            removeCard(getDeckOfCards().get(getRandomIndex()));
            System.out.println("Let's try again...");
            setRandomIndex();
            if (getDeckOfCards().get(getRandomIndex()).getSymbol() == lastCardSymbol && isCorrectInput()) {
                System.out.println(getDeckOfCards().get(getRandomIndex()));
                System.out.println("SNAP!");
            }
        }

    }
    public void snapSingleGame() {

        getDeck();
        shuffleDeck();
        Card firstCard = dealCard();
        System.out.println(firstCard);
        setRandomIndex();

        if (getDeckOfCards().get(getRandomIndex()).getSymbol() == firstCard.getSymbol() && isCorrectInput()) {
            System.out.println(getDeckOfCards().get(getRandomIndex()));
            System.out.println("SNAP!");
        } else {
            gameRunning();
        }
    }


    public void playerStack(Player player1, Player player2) {
        for (int i = 0; i < getDeckOfCards().size(); i++) {
            if(i%2==0){
                player1Stack.add(CardGame.getDeckOfCards().get(i));
            }else player2Stack.add(CardGame.getDeckOfCards().get(i));
        }
    }

    public Card dealPlayerOne(){
        Card top = getPlayer1Stack().get(0);
        getDiscardPile().add(top);
        player1Stack.remove(0);
        return top;
    }

    public void snapTwoPlayers(){
        getPlayer1Stack();
        getPlayer2Stack();
    }


}