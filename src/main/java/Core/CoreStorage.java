package Core;

import Exceptions.InvalidInput;
import Models.Player;

public class CoreStorage {

    private final Core core;

    public CoreStorage(Core core) {
        this.core = core;
    }

    public void storeProfileToJSD(Player player) {

    }

    public Player retrieveProfileFromJSD(String username) throws InvalidInput {
        return new Player(username);
    }
}
