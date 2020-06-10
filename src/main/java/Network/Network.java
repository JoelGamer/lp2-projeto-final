package Network;

import Core.Core;
import Network.Server.ConnectionHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Network {

    private final Socket socket;
    private final ArrayList<ConnectionHandler> connectionHandlers;
    private final BufferedReader bufferedReader;
    private final PrintWriter printWriter;

    public Network(Socket socket) throws IOException {
        this.socket = socket;
        this.connectionHandlers = null;
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.printWriter = new PrintWriter(this.socket.getOutputStream(), true);
    }

    public Network(Socket socket, ArrayList<ConnectionHandler> connectionHandlers) throws IOException {
        this.socket = socket;
        this.connectionHandlers = connectionHandlers;
        this.bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.printWriter = new PrintWriter(this.socket.getOutputStream(), true);
    }

    protected String receiveMessage() throws IOException {
        return bufferedReader.readLine();
    }

    protected void sendMessage(String message) {
        if(!message.equals("")) printWriter.println(message);
    }

    protected void broadcast(String message) {
        if(connectionHandlers == null || connectionHandlers.size() == 0) return;
        connectionHandlers.forEach(connectionHandler -> connectionHandler.getPrintWriter().println(message));
    }

    protected void closeConnection() {
        try {
            bufferedReader.close();
            printWriter.close();
            socket.close();
            System.out.println("Connection Closed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected BufferedReader getBufferedReader() {
        return this.bufferedReader;
    }

    protected PrintWriter getPrintWriter() {
        return this.printWriter;
    }
}
