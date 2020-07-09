package Core;

import Exceptions.InvalidInput;
import Models.Match;
import Models.Player;
import UI.ClientUI;
import java.util.Scanner;

public class CoreRoutes {

    private final ClientUI clientUI;
    private final Player player;

    public CoreRoutes(Player player) {
        this.clientUI = new ClientUI();
        this.player = player;
    }

    public void createMultiplayerSession() throws InvalidInput {
        Scanner scanner = new Scanner(System.in);

        clientUI.insertSecondPlayerUsername();
        String segundoNome = scanner.nextLine();

        new Match(player, new Player(segundoNome), clientUI).startMatch();
    }

    public void showStatistics() {
        this.player.getStatistics().showStatistics(this.player.getUsername());
    }

    public void changePlayerUsername() {
        String newUsername = performChangeUsername();
        if (newUsername != null) {
            try {
                player.setUsername(newUsername);
                System.out.println("Usuário alterado com sucesso!");
                System.out.println();
            } catch (InvalidInput e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String performChangeUsername() {
        Scanner scanner = new Scanner(System.in);
        String newUsername = "";

        clientUI.promptChangeUsername();
        newUsername = scanner.nextLine();
        clientUI.promptConfirmChangeUsername(newUsername);
        String response = scanner.nextLine();
        if(response.equalsIgnoreCase("Y")) return newUsername;
        else return null;
    }
}
