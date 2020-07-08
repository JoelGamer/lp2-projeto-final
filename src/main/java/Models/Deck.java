package Models;

import Exceptions.InvalidInput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = createDeck();
    }

    private ArrayList<Card> createDeck() {
        ArrayList<Card> cards = new ArrayList<>();

        for (int i=1;i<=4;i++){
            for(int j=1;j<=10;j++){
                try {
                    cards.add(new Card(i, j));
                } catch (InvalidInput e) {
                    e.printStackTrace();
                }
            }
        }

        return cards;
    }

    public Deck shuffle() {
        Collections.shuffle(cards);
        return this;
    }

    public List<Card> getArrayOfCards() {
        return this.cards;
    }

    public void setDeck(List<Card> cards) {
        this.cards.clear();
        this.cards.addAll(cards);
    }

    public void addCardToDeck(Card card) {
        cards.add(card);
    }

    public void displayDeck() {
        cards.forEach(Card::showCard);
    }
}
