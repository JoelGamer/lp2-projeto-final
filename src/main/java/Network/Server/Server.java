package Network.Server;

import Core.Core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final Core core;
    private final ArrayList<ConnectionHandler> connectionHandlers = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public Server(Core core) {
        this.core = core;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(core.getServerPort());

        while (true) {
            System.out.println("[SERVER] Awaiting client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("[SERVER] Client connected to the server!");
            ConnectionHandler connectionHandler = new ConnectionHandler(socket, connectionHandlers);
            connectionHandlers.add(connectionHandler);
            executorService.execute(connectionHandler);
        }
    }
}
