import Core.CoreOptions;
import Core.CoreStorage;
import Exceptions.InvalidInput;
import Models.Player;

public class Main {
    public static void main(String[] args) throws InvalidInput {
        CoreStorage coreStorage = new CoreStorage();
        Player player = coreStorage.retrieveProfileFromJSD();
        CoreOptions coreOptions = new CoreOptions(player);

        while (true) {
            if(coreOptions.showOptions()) break;
        }

        coreStorage.storeProfileToJSD(player);
    }
}
