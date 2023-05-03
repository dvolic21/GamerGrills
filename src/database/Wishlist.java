package database;
public class Wishlist {
    private int wishlist_id;
    private int game_key;
    private String user_key;
    private Game game;
    public Wishlist(int wishlist_id, int game_key, String user_key) {
        this.wishlist_id = wishlist_id;
        this.game_key = game_key;
        this.user_key=user_key;
    }

    public int getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(int wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public int getGame_key() {
        return game_key;
    }

    public void setGame_key(int game_key) {
        this.game_key = game_key;
    }
    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key=user_key;
    }
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game=game;
    }
    
}
