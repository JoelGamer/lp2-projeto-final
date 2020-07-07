package Models;

import Core.CoreGame;

public class Match {

    private final CoreGame coreGame;
    private final Deck deck;
    private final Player playerOne;
    private final Player playerTwo;

    public Match(Deck deck, Player playerOne, Player playerTwo) {
        this.coreGame = new CoreGame();
        this.deck = deck;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }
}
