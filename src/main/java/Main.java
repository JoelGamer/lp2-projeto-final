import Core.Core;
import Core.CoreConsole;
import Core.CoreOptions;
import Exceptions.InvalidInput;
import UI.ClientUI;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Core core = new Core("F:\\Projetos\\lp2-projeto-final\\src\\main\\resources\\config.properties");
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
