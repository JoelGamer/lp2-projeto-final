package UI;

import Core.Core;
import Models.Deck;
import Models.Player;

public class ClientUI {

    private final Core core;

    public ClientUI(Core core) {
        this.core = core;
    }

    public void mainPage() {
        System.out.println("----Main menu----");
        System.out.println("1 - Criar uma partida online.");
        System.out.println("2 - Juntar-se a uma partida online.");
        System.out.println("0 - Sair do jogo.");
    }

    public void awaitingPlayerToConnect() {
        System.out.println("Aguardando outro jogador para conectar...");
    }

    public void playerConnected() {
        System.out.println("Jogador se conectou a partida!");
    }

    public void insertName() {
        System.out.print("Coloque o seu nome de jogador para jogar com outra pessoa: ");
    }

    public void displayCurrentGameCards(Player player, Deck tableDeck) {
        System.out.println("Suas cartas:");
        player.getHand().showHand();
        System.out.println("Cartas na mesa:");
        tableDeck.displayDeck();
    }

    public void selectHandCard() {
        System.out.print("Selecione uma carta da sua mão para juntar com a da mesa ou para descarta-lá: ");
    }

    public void quantityToSelectFromTable() {
        System.out.print("Quantas cartas você deseja pegar da mesa? (0 para descartar a selecionada): ");
    }

    public void selectCardsFromTable() {
        System.out.print("Selecione a(s) carta(s) que deseja juntar com a sua carta: ");
    }

    public void exitMessage() {
        System.out.println("Obrigado por jogar o nosso jogo! Até mais!");
    }
}
