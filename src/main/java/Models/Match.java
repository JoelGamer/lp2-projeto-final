package Models;

import Core.CoreGame;
import Exceptions.InvalidGameMovement;
import Exceptions.InvalidInput;
import UI.ClientUI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Match implements Serializable {

    private static final long serialVersionUID = 1L;
    private final CoreGame coreGame;
    private final ClientUI clientUI;
    private final Deck deck;
    private final Deck tableDeck;
    private final Player playerOne;
    private final Player playerTwo;

    public Match(Player playerOne, Player playerTwo, ClientUI clientUI) {
        this.coreGame = new CoreGame();
        this.clientUI = clientUI;
        this.deck = new Deck().shuffle().shuffle();
        this.tableDeck = new Deck();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        coreGame.prepareMatch(playerOne, playerTwo, deck, tableDeck);
    }

    public void startMatch() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            clientUI.displayCurrentGameCards(playerOne, tableDeck);
            clientUI.selectHandCard();

            int selectedCard = -1;
            while (selectedCard < 0) {
                selectedCard = selectCardFromHand(playerOne.getHand(), scanner) - 1;
            }

            clientUI.quantityToSelectFromTable();
            int quantity = quantityToSelectFromTableDeck(scanner);
            clientUI.selectCardsFromTable();
            List<Integer> selectedCardsFromTable = selectCardFromTableDeck(tableDeck, scanner, quantity);

            try {
                coreGame.performGameMove(playerOne, tableDeck, selectedCard, selectedCardsFromTable);
            } catch (InvalidGameMovement e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int selectCardFromHand(Hand hand, Scanner scanner) {
        try {
            int selectedCard = Integer.parseInt(scanner.nextLine());
            if (hand.getCards().size() < selectedCard || selectedCard <= 0) throw new InvalidInput("Precisa inserir um número que seja entre " +
                    "as quantidades de cartas que você tem na mão!");
            return selectedCard;
        } catch (InvalidInput e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Você precisa inserir um número!");
        }
        return 0;
    }

    private int quantityToSelectFromTableDeck(Scanner scanner) {
        int quantity;

        while (true) {
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 0) throw new InvalidInput("A quantidade deve ser maior que 0!");
                return quantity;
            } catch (InvalidInput e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Você precisa inserir um número!");
            }
        }
    }

    private List<Integer> selectCardFromTableDeck(Deck tableDeck, Scanner scanner, int quantity) {
        List<Integer> selectedCards = new ArrayList<>();

        for (int i=0; i<quantity; i++) {
            while (true) {
                try {
                    int selectedCard = Integer.parseInt(scanner.nextLine());
                    if (tableDeck.getArrayOfCards().size() < selectedCard || selectedCard <= 0)
                        throw new InvalidInput("Precisa inserir um número que seja entre " +
                                "as quantidades de cartas que você tem na mão!");
                    selectedCards.add(selectedCard - 1);
                    break;
                } catch (InvalidInput e) {
                    System.out.println(e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("Você precisa inserir um número!");
                }
            }
        }

        return selectedCards;
    }
}
