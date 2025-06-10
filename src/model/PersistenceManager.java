package model;

import java.io.*;

public class PersistenceManager {

    // Salva o estado atual do tabuleiro em um arquivo (serializado)
    public static void saveGame(Board board, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(board);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega o estado salvo do tabuleiro
    public static Board loadGame(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Board) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Salva o ranking dos jogadores
    public static void saveRanking(Ranking ranking, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(ranking);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carrega o ranking dos jogadores
    public static Ranking loadRanking(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Ranking) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}