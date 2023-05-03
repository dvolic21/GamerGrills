package database;

public class Genre {
    private int genre_key;
    private String genre;
    private String theme;
    private int parent_genre_key;

    public Genre(int genre_key, String genre,String theme, int parent_genre_key) {
        this.genre_key = genre_key;
        this.genre = genre;
        this.theme = theme;
        this.parent_genre_key = parent_genre_key;
    }

    public int getGenre_key() {
        return genre_key;
    }

    public void setGenre_key(int genre_key) {
        this.genre_key = genre_key;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public int getParent_genre_key() {
        return parent_genre_key;
    }

    public void setParent_genre_key(int parent_genre_key) {
        this.parent_genre_key = parent_genre_key;
    }

}
