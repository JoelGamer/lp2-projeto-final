package Network.v2.Client.ConnectionHandlers;

import Models.Match;
import Network.v2.Network;

import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler extends Network implements Runnable {

    private Match match;

    public ConnectionHandler(Match match, Socket socket) throws IOException {
        super(socket);
        this.match = match;
    }

    @Override
    public void run() {
        while (getSocket().isConnected()) {
            Match nextMovement = null;
            try {
                nextMovement = receiveGameMovement();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(nextMovement != null) this.match = nextMovement;
        }
    }
}
