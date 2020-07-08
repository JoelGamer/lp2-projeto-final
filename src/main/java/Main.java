import Core.Core;
import Core.CoreOptions;
import Core.CoreStorage;
import Exceptions.InvalidInput;
import Models.Player;

public class Main {
    public static void main(String[] args) throws InvalidInput {
        Core core = new Core();
        CoreStorage coreStorage = new CoreStorage();
        Player player = coreStorage.retrieveProfileFromJSD();
        CoreOptions coreOptions = new CoreOptions(core, player);

        while (true) {
            if(coreOptions.showOptions()) break;
        }

        coreStorage.storeProfileToJSD(player);
    }
}
