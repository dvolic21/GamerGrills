package database;

public class Publisher {
    private int publisher_id;
    private String publisher_name;
    private String developer;

    public Publisher(int publisher_key, String publisher_name, String developer) {
        this.publisher_id = publisher_key;
        this.publisher_name = publisher_name;
        this.developer = developer;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

}
