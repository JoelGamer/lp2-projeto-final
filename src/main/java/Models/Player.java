package Models;

import Exceptions.InvalidCredentials;
import Exceptions.InvalidInput;
import java.util.List;

public class Player {
    private final String username;
    private final String password;
    private final Hand hand;
    private double score;

    public Player(String username, String password) throws InvalidCredentials {
        if(username.equals("") || password.equals("")) throw new InvalidCredentials("Username or password is incorrect!");
        this.username = username;
        this.password = password;
        this.hand = new Hand();
        this.score = retrieveScore();
    }

    public void showHand() {

    }

    private double retrieveScore() {
        return 0.0;
    }

    public void addToHand(Card card) throws InvalidInput {
        if(card == null) throw new InvalidInput("Cannot add a invalid card to the hand!");
        hand.addCardToHand(card);
    }

    public void addToScore(double score) throws InvalidInput {
        if(score <= 0) throw new InvalidInput("Cannot add a value lower than 1 to the player score!");
        this.score += score;
    }

    public String getUsername() {
        return username;
    }

    private String getPassword() {
        return password;
    }

    public double getScore() {
        return score;
    }
}
