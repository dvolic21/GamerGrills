package database;
import java.util.List;

public class GameSales {
    private int game_sale_code;
    private String game_code;
    private double price;
    private String date;
    private int type_of_payment;
    private String user_key;
    private int game_key;
    private Game game;
    private List<GameSales> purchase;
    public GameSales(int game_sale_code, String game_code, double price, String date, int type_of_payment, String user_key,
            int game_key) {
        this.game_sale_code = game_sale_code;
        this.game_code = game_code;
        this.price = price;
        this.date = date;
        this.type_of_payment = type_of_payment;
        this.user_key = user_key;
        this.game_key = game_key;
    }

    public int getGame_sale_code() {
        return game_sale_code;
    }

    public void setGame_sale_code(int game_sale_code) {
        this.game_sale_code = game_sale_code;
    }

    public String getGame_code() {
        return game_code;
    }

    public void setGame_code(String game_code) {
        this.game_code = game_code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType_of_payment() {
        return type_of_payment;
    }

    public void setType_of_payment(int type_of_payment) {
        this.type_of_payment = type_of_payment;
    }

    public String getUser_key() {
        return user_key;
    }

    public void setUser_key(String user_key) {
        this.user_key = user_key;
    }

    public int getGame_key() {
        return game_key;
    }

    public void setGame_key(int game_key) {
        this.game_key = game_key;
    }
    public Game getGame() {
        return game;

    }
    public void setGame(Game game) {
        this.game=game;
    }
    public List<GameSales> getPurchase() {
        return purchase;
    }
    public void setPurchase(GameSales game) {
        purchase.add(game);
    }
}
