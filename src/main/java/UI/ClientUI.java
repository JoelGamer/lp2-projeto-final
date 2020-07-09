package UI;

import Models.Deck;
import Models.Player;

public class ClientUI {

    public void mainPage() {
        System.out.println("----Main menu----");
        System.out.println("1 - Iniciar uma partida.");
        System.out.println("2 - Mostrar as suas estatisticas de jogo.");
        System.out.println("3 - Alterar o seu nome de usuário.");
        System.out.println("0 - Sair do jogo.");
        printEmptyLine();
    }

    public void displayCurrentGameCards(Player player, Deck tableDeck) {
        System.out.println("Cartas do jogador(a) " + player.getUsername() + ":");
        player.getHand().showHand();
        System.out.println("Cartas na mesa:");
        tableDeck.displayDeck();
        printEmptyLine();
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
        System.out.println("Seu perfil foi salvo!");
        System.out.println("Obrigado por jogar o nosso jogo! Até mais!");
        printEmptyLine();
    }

    public void promptChangeUsername() {
        System.out.print("Insere o seu novo usuário: ");
    }

    public void promptConfirmChangeUsername(String username) {
        System.out.println("Confirma esse seu novo usuário? " + username);
        printEmptyLine();
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void insertSecondPlayerUsername() {
        System.out.print("Insira o nome do segundo jogador: ");
    }
}
