package Core;

import Exceptions.InvalidInput;
import Models.Match;
import Models.Player;
import UI.ClientUI;

import java.util.Scanner;

public class CoreRoutes {

    private final ClientUI clientUI;

    public CoreRoutes(Core core) {
        this.clientUI = new ClientUI(core);
    }

    public void multiplayerMatch(Scanner scanner) throws InvalidInput {
        clientUI.insertName();
        String name = scanner.nextLine();
        Player player = new Player(name);

        new Match(player, new Player("Bot Gerson"), clientUI).startMatch();
    }

    public void onlineMultiplayerMatch(Scanner scanner) {

    }
}
