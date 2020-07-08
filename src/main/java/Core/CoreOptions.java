package Core;

import Exceptions.InvalidInput;
import Models.Player;
import UI.ClientUI;
import java.util.Scanner;

public class CoreOptions {

    private final Player player;
    private final ClientUI clientUI;
    private final CoreRoutes coreRoutes;

    public CoreOptions(Core core, Player player) {
        this.player = player;
        this.clientUI = new ClientUI(core);
        this.coreRoutes = new CoreRoutes(core, this.player);
    }

    public boolean showOptions() {
        Scanner scanner = new Scanner(System.in);
        clientUI.mainPage();

        int option;
        try {
            option = scanner.nextInt();
        } catch (Exception i) {
            option = -1;
        }

        scanner.nextLine();
        try {
            return optionsRedirects(option, scanner);
        } catch (InvalidInput e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean optionsRedirects(int option, Scanner scanner) throws InvalidInput {
        switch(option) {
            case 1 :
                coreRoutes.multiplayerOnlineMatch();
                break;
            case 3 :
                coreRoutes.showStatistics();
                break;
            case 4 :
                coreRoutes.changePlayerUsername();
                break;
            case 0 :
                clientUI.exitMessage();
                return true;
            default :
                throw new InvalidInput("O valor que você informou é inválido! Insira novamente!\n");
        }
        return false;
    }
}
