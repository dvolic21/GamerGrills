package database;

public class Rating {
    private int rating_id;
    private String rating;
    private String minimum_age;
    private String description;
    public Rating(int rating_id, String rating, String minimum_age, String description) {
        this.rating_id= rating_id;
        this.rating = rating;
        this.minimum_age = minimum_age;
        this.description = description;
    }
    public int getRating_id() {
        return rating_id;
    }
    public void setRating_id(int rating_id) {
        this.rating_id= rating_id;
    }
    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getMinimum_age() {
        return minimum_age;
    }
    public void setMinimum_age(String minimum_age) {
        this.minimum_age = minimum_age;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
