package Core;

import Exceptions.InvalidGameMovement;
import Exceptions.InvalidInput;
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

    public void performGameMove(Player player, Deck tableDeck, int selectedHandCard, List<Integer> selectedCards) throws InvalidGameMovement {
        Card playerCard = player.getHand().getCards().get(selectedHandCard);
        List<Card> selectedTableCards = getSelectedTableCards(tableDeck.getArrayOfCards(), selectedCards);

        if(selectedTableCards.isEmpty()) {
            discardCardFromHand(player.getHand(), playerCard, tableDeck);
            return;
        }

        movementIsValid(playerCard, selectedTableCards);

        performCardGameMove(player, tableDeck, playerCard, selectedTableCards);
    }

    public void giveNewHand(Player a, Player b, Deck deck) {
        List<Hand> hands = List.of(a.getHand(), b.getHand());
        prepareHandForEachPlayer(hands, deck.getArrayOfCards());
    }

    public void finishGame(Player playerOne, Player playerTwo) throws InvalidInput {
        if(playerOne.getScoreHand().getCards().size() >= playerTwo.getScoreHand().getCards().size()) playerOne.addToScore(1);
        else playerTwo.addToScore(1);

        performEscovasCalculation(playerOne);
        performEscovasCalculation(playerTwo);
        performMajorityIsDiamonds(playerOne, playerTwo);
        performHasAllSevens(playerOne, playerTwo);

        String winner = (playerOne.getScore() > playerTwo.getScore()) ? playerOne.getUsername() : playerTwo.getUsername();
        System.out.println("E o ganhador da partida foi: " + winner);
        System.out.println();
    }

    private void performEscovasCalculation(Player player) throws InvalidInput {
        if(player.getQuantityEscovas() > 0) player.addToScore(player.getQuantityEscovas());
    }

    private void performMajorityIsDiamonds(Player playerOne, Player playerTwo) throws InvalidInput {
        List<Card> playerOneCards = new ArrayList<>();
        List<Card> playerTwoCards = new ArrayList<>();

        for(Card card : playerOne.getScoreHand().getCards()) {
            if(card.getSuit() == 2) playerOneCards.add(card);
        }
        for(Card card : playerTwo.getScoreHand().getCards()) {
            if(card.getSuit() == 2) playerTwoCards.add(card);
        }

        if (playerOneCards.size() >= playerTwoCards.size()) playerOne.addToScore(1);
        else playerTwo.addToScore(1);
    }

    private void performHasAllSevens(Player playerOne, Player playerTwo) throws InvalidInput {
        List<Card> playerOneCards = new ArrayList<>();
        List<Card> playerTwoCards = new ArrayList<>();

        for(Card card : playerOne.getScoreHand().getCards()) {
            if(card.getScore() == 7 && card.getSuit() == 2) playerOne.addToScore(1);
            if(card.getScore() == 7) playerOneCards.add(card);
        }
        for(Card card : playerTwo.getScoreHand().getCards()) {
            if(card.getScore() == 7 && card.getSuit() == 2) playerTwo.addToScore(1);
            if(card.getScore() == 7) playerTwoCards.add(card);
        }

        if(playerOneCards.size() == 4) playerOne.addToScore(3);
        if(playerTwoCards.size() == 4) playerTwo.addToScore(3);
    }

    private void performCardGameMove(Player player, Deck tableDeck, Card playerCard, List<Card> selectedTableCards) {
        if (selectedTableCards.size() == tableDeck.getArrayOfCards().size()) player.sumOneToEscovas();

        player.getScoreHand().addCardToHand(playerCard);
        player.getHand().getCards().remove(playerCard);

        for (Card card : selectedTableCards) {
            player.getScoreHand().addCardToHand(card);
            tableDeck.getArrayOfCards().remove(card);
        }
    }

    private void movementIsValid(Card playerCard, List<Card> selectedTableCards) throws InvalidGameMovement {
        int totalPoints = playerCard.getScore();
        for (Card card : selectedTableCards) {
            totalPoints += card.getScore();
        }
        if(totalPoints != 15) throw new InvalidGameMovement("Você não pode fazer esse movimento! Você precisa selecionar " +
                "cartas que igualam a soma de 15.");
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
                System.out.println(deckCards.size());
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
