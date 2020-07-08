package Core;

import Exceptions.InvalidInput;
import Models.Player;

import java.io.*;

public class CoreStorage {

    private final String SAVED_ARCHIVE_NAME = "SavedProfileData.jsd";

    public void storeProfileToJSD(Player player) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(SAVED_ARCHIVE_NAME));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(player);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player retrieveProfileFromJSD() throws InvalidInput {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(SAVED_ARCHIVE_NAME));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Player) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Dados do perfil não foram encontrados! Criando um novo perfil...");
            return new Player("player_" + (int)(Math.random() * 10000000));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
