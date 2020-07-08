package Network.v2;

import Models.Match;
import java.io.*;
import java.net.Socket;

public class Network {

    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    public Network(Socket socket) throws IOException {
        this.socket = socket;
        this.objectInputStream = new ObjectInputStream(socket.getInputStream());
        this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    protected Match receiveGameMovement() throws IOException, ClassNotFoundException {
        return (Match) objectInputStream.readObject();
    }

    protected void sendGameMovement(Match match) throws IOException {
        objectOutputStream.writeObject(match);
    }

    protected void closeConnection() {
        try {
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
            System.out.println("Connection Closed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected ObjectInputStream getObjectInputStream() {
        return this.objectInputStream;
    }

    protected ObjectOutputStream getObjectOutputStream() {
        return this.objectOutputStream;
    }

    protected Socket getSocket() {
        return this.socket;
    }
}
