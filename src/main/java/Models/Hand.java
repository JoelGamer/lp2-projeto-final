package Models;

import Exceptions.InvalidInput;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards = new ArrayList<>();

    public void addCardToHand(Card card) {
        cards.add(card);
    }

    public void setHandCards(List<Card> cards) throws InvalidInput {
        if(cards == null || cards.size() <= 0) throw new InvalidInput("Cannot give a initial hand without any cards!");
        this.cards = cards;
    }

    public void showHand() {
        cards.forEach(Card::showCard);
    }

    public List<Card> getCards() {
        return this.cards;
    }
}
