import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand> {

    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        cards.add(card);
    }

    public void print() {
        cards.forEach(card -> System.out.println(card));
    }

    public void sort() {
        Collections.sort(cards);
    }

    @Override
    public int compareTo(Hand hand) {

        int thisSum = cards.stream()
                .mapToInt(card -> card.getValue())
                .sum();

        int otherSum = hand.cards.stream()
                .mapToInt(card -> card.getValue())
                .sum();

        return thisSum - otherSum;
    }

    public void sortBySuit() {
        Collections.sort(cards, new BySuitInValueOrder());
    }
}