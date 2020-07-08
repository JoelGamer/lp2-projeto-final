package Models;

import Exceptions.InvalidInput;

public class Card {
    private int suit;
    private int value;
    private int score;

    public Card(int suit, int value) throws InvalidInput {
        setSuit(suit);
        setValue(value);
        setScore(value);
    }

    public void showCard() {
        System.out.println(getStringValue() + " of " + getStringSuit());
    }

    private void setSuit(int suit) throws InvalidInput {
        if(suit > 4 || suit < 0) throw new InvalidInput("Cannot set suit to a value lower than 1 and greater than 4");
        this.suit = suit;
    }

    public String getStringSuit() {
        switch (suit) {
            case 1 :
                return "Hearts";
            case 2 :
                return "Diamonds";
            case 3 :
                return "Spades";
            case 4 :
                return "Clubs";
            default :
                return "";
        }
    }

    private void setValue(int value) throws InvalidInput {
        if(value > 10) throw new InvalidInput("Cannot set value to a value greater than 10");
        this.value = value;
    }

    public String getStringValue() {
        switch (value) {
            case 1 :
                return "A";
            case 8 :
                return "J";
            case 9 :
                return "Q";
            case 10 :
                return "K";
            default :
                return String.valueOf(value);
        }
    }

    private void setScore(int score) throws InvalidInput {
        if(score < 1) throw new InvalidInput("Cannot set score to a value lower than 1");
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
