package database;

import java.util.ArrayList;
import java.util.List;

public class Game_Features {
    private int game_features_id;
    private int game_id;
    private int features_id;
    private Features features;
    private Game games;
    private List<Game_Features> game_features=new ArrayList<>();

    public Game_Features(int game_features_id, int game_id, int features_id) {
        this.game_features_id = game_features_id;
        this.game_id = game_id;
        this.features_id = features_id;
    }

    public int getGame_features_id() {
        return game_features_id;
    }

    public void setGame_features_id(int game_features_id) {
        this.game_features_id = game_features_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getFeatures_id() {
        return features_id;
    }

    public void setFeatures_id(int features_id) {
        this.features_id = features_id;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public Game getGames() {
        return games;
    }

    public void setGames(Game games) {
        this.games = games;
    }

    public List<Game_Features> getGame_features() {
        return game_features;
    }

    public void setGame_features(Game_Features game_features) {
        this.game_features.add(game_features);
    }

}
