package Core;

import Exceptions.InvalidInput;
import Models.Match;
import Models.Player;
import UI.ClientUI;

import java.util.Scanner;

public class CoreRoutes {

    private final ClientUI clientUI;
    private final Player player;

    public CoreRoutes(Core core, Player player) {
        this.clientUI = new ClientUI(core);
        this.player = player;
    }

    public void multiplayerOnlineMatch() throws InvalidInput {
        new Match(this.player, new Player("Bot Gerson"), clientUI).startMatch();
    }

    public void showStatistics() {

    }

    public void changePlayerUsername() {

    }
}
