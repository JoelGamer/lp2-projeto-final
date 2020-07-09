package Models;

import java.io.Serializable;

public class Statistics implements Serializable {
    private static final long serialVersionUID = 1L;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLoss;

    public Statistics() {
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLoss = 0;
    }

    public void sumOneToGamesPlayed() {
        gamesPlayed += 1;
    }

    public void sumOneToGamesWon() {
        gamesWon += 1;
    }

    public void sumOneToGamesLoss() {
        gamesLoss += 1;
    }

    public void showStatistics(String username) {
        System.out.println("Estatisticas do(a) " + username);
        System.out.println("Partidas jogadas: " + gamesPlayed);
        System.out.println("Partidas ganhas: " + gamesWon);
        System.out.println("Partidas perdidas: " + gamesLoss);
        System.out.println("V/D: " + getVictoriesPerDefeat());
    }

    @SuppressWarnings("IntegerDivisionInFloatingPointContext")
    private double getVictoriesPerDefeat() {
        if(gamesWon == 0 && gamesLoss == 0) {
            return 0.0;
        }
        if(gamesLoss == 0) {
            return gamesWon;
        }
        return gamesWon / gamesLoss;
    }
}
