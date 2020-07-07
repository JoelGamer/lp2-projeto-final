package Network.Client;

import Core.Core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final Core core;

    public Client(Core core) {
        this.core = core;
    }

    public void start() throws IOException {
        Socket socket = new Socket(core.getServerHost(), core.getServerPort());

        new Thread(new ConnectionHandler(socket)).start();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter sender = new PrintWriter(socket.getOutputStream(), true);

        String name = input.readLine();

        while (true) {
            String message = input.readLine();

            if(message.equals("quit")) break;
            if(!message.equals("")) sender.println(name + ": " + message);
        }
    }
}
