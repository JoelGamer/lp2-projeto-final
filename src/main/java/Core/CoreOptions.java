package Core;

import Exceptions.InvalidInput;
import Models.Player;
import UI.ClientUI;

import java.io.IOException;
import java.util.Scanner;

public class CoreOptions {

    private final ClientUI clientUI;
    private final CoreRoutes coreRoutes;

    public CoreOptions(Player player) {
        this.clientUI = new ClientUI();
        this.coreRoutes = new CoreRoutes(player);
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
            return optionsRedirects(option);
        } catch (InvalidInput | IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean optionsRedirects(int option) throws InvalidInput, IOException {
        switch(option) {
            case 1 :
                coreRoutes.createMultiplayerSession();
                break;
            case 2 :
                coreRoutes.showStatistics();
                break;
            case 3 :
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
