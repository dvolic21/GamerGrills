package database;

public class Game {
    private int game_id;
    private String game_name;
    private String game_image;
    private String game_description;
    private int price_key;
    private int release_key;
    private int specs_key;
    private int rating_key;
    private int publisher_key;
    private Price prices;
    private ReleaseDate date;
    private SystemSpecs specs;
    private Publisher publisher;
    private Rating rating;

    public Game(int game_id, String game_name, String game_image, String game_description, int price_key,
            int release_key, int specs_key,
            int rating_key, int publisher_key) {
        this.game_id = game_id;
        this.game_name = game_name;
        this.game_image = game_image;
        this.game_description = game_description;
        this.price_key = price_key;
        this.release_key = release_key;
        this.specs_key = specs_key;
        this.rating_key = rating_key;
        this.publisher_key = publisher_key;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getGame_image() {
        return game_image;
    }

    public void setGame_image(String game_image) {
        this.game_image = game_image;
    }

    public int getPrice_key() {
        return price_key;
    }

    public void setPrice_key(int price_key) {
        this.price_key = price_key;
    }

    public int getRelease_key() {
        return release_key;
    }

    public void setRelease_key(int release_key) {
        this.release_key = release_key;
    }

    public int getSpecs_key() {
        return specs_key;
    }

    public void setSpecs_key(int specs_key) {
        this.specs_key = specs_key;
    }

    public int getRating_key() {
        return rating_key;
    }

    public void setRating_key(int rating_key) {
        this.rating_key = rating_key;
    }

    public String getGame_description() {
        return game_description;
    }

    public void setGame_description(String game_description) {
        this.game_description = game_description;
    }

    public int getPublisher_key() {
        return publisher_key;
    }

    public void setPublisher_key(int publisher_key) {
        this.publisher_key = publisher_key;
    }

    public Price getPrices() {
        return prices;
    }

    public void setPrices(Price prices) {
        this.prices = prices;
    }

    public ReleaseDate getDate() {
        return date;
    }

    public void setDate(ReleaseDate date) {
        this.date = date;
    }

    public SystemSpecs getSpecs() {
        return specs;
    }

    public void setSpecs(SystemSpecs specs) {
        this.specs = specs;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
