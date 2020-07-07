package Models;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public Hand() {

    }

    public void addCardToHand(Card card) {
        cards.add(card);
    }
}
