package Core;

import Exceptions.InvalidGameMovement;
import Models.Card;
import Models.Deck;
import Models.Hand;
import Models.Player;

import java.util.ArrayList;
import java.util.List;

public class CoreGame {

    public void prepareMatch(Player a, Player b, Deck deck, Deck tableDeck) {
        List<Hand> hands = List.of(a.getHand(), b.getHand());
        prepareHandForEachPlayer(hands, deck.getArrayOfCards());
        prepareTableCards(deck.getArrayOfCards(), tableDeck);
    }

    public void performGameMove(Player player, Deck tableDeck, int selectedHandCard, List<Integer> selectedCards)
            throws InvalidGameMovement {
        Card playerCard = player.getHand().getCards().get(selectedHandCard);
        List<Card> selectedTableCards = getSelectedTableCards(tableDeck.getArrayOfCards(), selectedCards);
        System.out.println("----------------------");
        playerCard.showCard();
        selectedTableCards.forEach(Card::showCard);

        if(selectedTableCards.isEmpty()) {
            discardCardFromHand(player.getHand(), playerCard, tableDeck);
            return;
        }

        movementIsValid(playerCard, selectedTableCards);
    }

    private void movementIsValid(Card playerCard, List<Card> selectedTableCards) throws InvalidGameMovement {
        int totalPoints = playerCard.getScore();
        for (Card card : selectedTableCards) {
            totalPoints += card.getScore();
        }

        System.out.println(totalPoints);
        if(totalPoints != 15) throw new InvalidGameMovement("You cannot perform this movement! You need to select cards " +
                "that equal to a value of 15.");
    }

    private List<Card> getSelectedTableCards(List<Card> tableCards, List<Integer> selectedCards) {
        List<Card> cards = new ArrayList<>();
        for (Integer selected : selectedCards) {
            cards.add(tableCards.get(selected));
        }
        return cards;
    }

    private void discardCardFromHand(Hand playerHand, Card playerCard, Deck tableDeck) {
        playerHand.getCards().remove(playerCard);
        tableDeck.getArrayOfCards().add(playerCard);
    }

    private void prepareHandForEachPlayer(List<Hand> playersHand, List<Card> deckCards) {
        for (Hand hand : playersHand) {
            for (int i=0;i<3;i++){
                Card card = deckCards.get(i);
                hand.addCardToHand(card);
                deckCards.remove(card);
            }
        }
    }

    private void prepareTableCards(List<Card> deckCards, Deck tableCards) {
        List<Card> cards = new ArrayList<>();

        for (int i=0;i<4;i++) {
            Card card = deckCards.get(i);
            cards.add(card);
            deckCards.remove(card);
        }

        tableCards.setDeck(cards);
    }
}
