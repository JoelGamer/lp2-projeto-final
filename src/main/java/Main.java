import Core.Core;
import Core.CoreConsole;
import Core.CoreOptions;
import Exceptions.InvalidInput;
import Models.Match;
import Models.Player;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InvalidInput {
        Core core = new Core();
        CoreConsole coreConsole = new CoreConsole(core);
        CoreOptions coreOptions = new CoreOptions(core);

        while (true) {
            if(coreOptions.showOptions()) break;
        }
    }

    private static boolean buildForServer(String[] args) {
        return args.length > 0 && args[0].equals("-s");
    }
}
