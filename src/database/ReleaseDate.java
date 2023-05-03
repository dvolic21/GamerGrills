package database;

public class ReleaseDate {
    private int release_key;
    private String release_date;
    public ReleaseDate(int release_key, String release_date) {
        this.release_key = release_key;
        this.release_date = release_date;
    }
    public int getRelease_key() {
        return release_key;
    }
    public void setRelease_key(int release_key) {
        this.release_key = release_key;
    }
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}
