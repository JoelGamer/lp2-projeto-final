package Network.v2.Client.ConnectionHandlers;

import Network.Network;

import java.io.IOException;
import java.net.Socket;

public class ClientConnectionHandler extends Network {
    public ClientConnectionHandler(Socket socket) throws IOException {
        super(socket);
    }
}
