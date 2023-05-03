package database;


public class Game_Genre {
    private int game_genre_id;
    private int genre_id;
    private int game_id;
    private Genre genre;
    private Game game;
    private Game_Genre gg;
    public Game_Genre(int game_genre_id, int genre_id, int game_id) {
        this.game_genre_id = game_genre_id;
        this.genre_id = genre_id;
        this.game_id = game_id;
    }

    public int getGame_genre_id() {
        return game_genre_id;
    }

    public void setGame_genre_id(int game_genre_id) {
        this.game_genre_id = game_genre_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }
    public void setGenre(Genre genre){
        this.genre=genre;
    }
    public Genre getGenre(){
        return genre;
    }
    public void setGame(Game game){
        this.game=game;
    }
    public Game getGame(){
        return game;
    }
    public void setGG(Game_Genre gg){
        this.gg=gg;
    }
    public Game_Genre getGG(){
        return gg;
    }
}
