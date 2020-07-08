package Network;

import Core.Core;
import Exceptions.InvalidInput;
import Models.Player;
import UI.ClientUI;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkedPlayer extends Player {

    private final Core core;
    private final ClientUI clientUI;

    public NetworkedPlayer(String username, Core core) throws InvalidInput {
        super(username);
        this.core = core;
        this.clientUI = new ClientUI(core);
    }

    public void createAsHost() throws IOException {
        ServerSocket serverSocket = new ServerSocket(core.getServerPort());
        clientUI.awaitingPlayerToConnect();
        Socket clientSocket = serverSocket.accept();
        clientUI.playerConnected();


    }

    public void createAsClient() throws IOException {
        Socket socket = new Socket(core.getServerHost(), core.getServerPort());
    }
}
