package Models;

import Exceptions.InvalidInput;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private final Hand hand;
    private final Hand scoreHand;
    private final Statistics statistics;
    private int quantityEscovas;
    private double score;

    public Player(String username) throws InvalidInput {
        if(username.equals("")) throw new InvalidInput("Username cannot be empty!");
        this.username = username;
        this.hand = new Hand();
        this.scoreHand = new Hand();
        this.statistics = new Statistics();
        this.quantityEscovas = 0;
        this.score = 0;
    }

    public void addToHand(Card card) throws InvalidInput {
        if(card == null) throw new InvalidInput("Cannot add a invalid card to the hand!");
        hand.addCardToHand(card);
    }

    public void giveInitialHand(List<Card> cards) throws InvalidInput {
        this.hand.setHandCards(cards);
    }

    public void addToScore(double score) throws InvalidInput {
        if(score <= 0) throw new InvalidInput("Cannot add a value lower than 1 to the player score!");
        this.score += score;
    }

    public void sumOneToEscovas() {
        this.quantityEscovas += 1;
    }

    public String getUsername() {
        return this.username;
    }

    public Hand getHand() {
        return this.hand;
    }

    public Hand getScoreHand() {
        return this.scoreHand;
    }

    public Statistics getStatistics(){
        return this.statistics;
    }

    public int getQuantityEscovas() {
        return this.quantityEscovas;
    }

    public double getScore() {
        return this.score;
    }

    public void setUsername(String username) throws InvalidInput {
        if(username.equals("")) throw new InvalidInput("Username cannot be empty!");
        this.username = username;
    }
}
