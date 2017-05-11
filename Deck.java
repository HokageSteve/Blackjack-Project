import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> aryDeck = new ArrayList<Card>();
    private int intCounterDeck = 0;

    public Deck() {
        init();
    }

    public Deck(int intDecks) {
        int intCounter = 0;
        while(intCounter < intDecks) {
            init();
            intCounter++;
        }
    }
    private void init() {
        int intCounter = 1;
        while(intCounter <= 52) {
            aryDeck.add(new Card(intCounter));
            intCounter++;
        }
    }
    public int percentLeft() {

        return ((this.intCounterDeck * 100) / aryDeck.size());
    }

    public boolean shouldShuffle() {
        int intShufflePercent = 75;
        int intCurrentPercent = percentLeft();
        if(intCurrentPercent > intShufflePercent) {
            return true;
        }

        return false;
    }
    public void shuffle() {
        System.out.println("Shuffling...");
        Collections.shuffle(aryDeck);
        intCounterDeck = 0;
    }
    public Card getCard() {
        return aryDeck.get(intCounterDeck++);
    }
    public String toString() {
        return aryDeck.toString() + " - %" + percentLeft();
    }
    public static void main(String [] strArgs) {
        Deck objDeck = new Deck();
        int intTestNumberOfCards = 60;
        int intCurrentCard = 0;

        System.out.println(objDeck);

        while(intCurrentCard < intTestNumberOfCards) {
            if(objDeck.shouldShuffle()) {
                objDeck.shuffle();
                System.out.println(objDeck);
            }
            System.out.println(objDeck.getCard());
            intCurrentCard++;
        }   
    }