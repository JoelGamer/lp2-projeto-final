package Core;

import Exceptions.InvalidInput;
import UI.ClientUI;
import java.util.Scanner;

public class CoreOptions {

    ClientUI clientUI;
    CoreRoutes coreRoutes;

    public CoreOptions(Core core) {
        this.clientUI = new ClientUI(core);
        this.coreRoutes = new CoreRoutes();
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
                coreRoutes.singleplayerMatch(scanner);
                break;
            case 2 :
                coreRoutes.multiplayerMatch(scanner);
                break;
            case 3 :
                coreRoutes.onlineMultiplayerMatch(scanner);
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
