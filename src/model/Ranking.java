package model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Ranking implements Serializable {
    private Map<String, Integer> ranking;

    public Ranking() {
        ranking = new HashMap<>();
    }

    public void addVictory(String playerName) {
        ranking.put(playerName, ranking.getOrDefault(playerName, 0) + 1);
    }

    public Map<String, Integer> getRanking() {
        return ranking;
    }

    public void saveRanking(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(ranking);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRanking(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ranking = (Map<String, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}