package database;

public class Review {
    private int review_id;
    private int review_stars;
    private String review_comment;
    private String user_key;
    private int game_key;
    private Game game;
    public Review(int review_id, int review_stars, String review_comment, String user_key, int game_key) {
        this.review_id = review_id;
        this.review_stars = review_stars;
        this.review_comment = review_comment;
        this.user_key = user_key;
        this.game_key = game_key;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getReview_stars() {
        return review_stars;
    }

    public void setReview_stars(int review_stars) {
        this.review_stars = review_stars;
    }

    public String getReview_comment() {
        return review_comment;
    }

    public void setReview_comment(String review_comment) {
        this.review_comment = review_comment;
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
        this.game = game;
    }
}
