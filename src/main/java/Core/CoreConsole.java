package Core;

import Exceptions.InvalidStatus;

public class CoreConsole {

    private final Core core;

    public CoreConsole(Core core) {
        this.core = core;
    }

    public void showConsoleMessage(String message, int status) throws InvalidStatus {
        if(message == null || message.equals("")) throw new InvalidStatus("There is no message to show!");

        switch (status) {
            case 1 :
                System.out.println(core.getConsoleTags().get(0) + " " + message);
                break;
            case 2 :
                System.out.println("\u001B[33m" + core.getConsoleTags().get(1) + " " +  message + "\u001B[0m");
                break;
            case 3 :
                System.out.println("\u001B[31m" + core.getConsoleTags().get(2) + " " + message + "\u001B[0m");
                break;
            default :
                throw new InvalidStatus("This status code doesn't exist!");
        }
    }

    public Core getCore() {
        return core;
    }
}
