package Network.Server;

import Network.Network;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class ConnectionHandler extends Network implements Runnable {
    public ConnectionHandler(Socket socket, ArrayList<ConnectionHandler> connectionHandlers) throws IOException {
        super(socket, connectionHandlers);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = receiveMessage();
                if(message == null) break;
                System.out.println(message);
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
