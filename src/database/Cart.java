package database;

public class Cart {
    private int cart_id;
    private int game_key;
    private String user_key;
    private Game game;
    public Cart(int cart_id, int game_key, String user_key) {
        this.cart_id = cart_id;
        this.game_key = game_key;
        this.user_key=user_key;
    }

    public int getCart_key() {
        return cart_id;
    }

    public void setCart_key(int cart_id) {
        this.cart_id = cart_id;
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

    public void getUser_key(String user_key) {
        this.user_key = user_key;
    }
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
