import Core.Core;
import Core.CoreConsole;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Core core = new Core("src/main/java/resources/config.properties");
        CoreConsole coreConsole = new CoreConsole(core);
    }

    private static boolean buildForServer(String[] args) {
        return args.length > 0 && args[0].equals("-s");
    }
}
