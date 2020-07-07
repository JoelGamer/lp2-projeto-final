package Network.Client;

import Network.Network;
import java.io.IOException;
import java.net.Socket;

public class ConnectionHandler extends Network implements Runnable {
    protected ConnectionHandler(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = receiveMessage();
                if(message == null)  break;
                System.out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
