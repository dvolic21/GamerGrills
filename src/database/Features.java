package database;

public class Features {
    private int features_id;
    private String name;
    private String description;

    public Features(int features_id, String name, String description) {
        this.features_id = features_id;
        this.name = name;
        this.description = description;
    }

    public int getFeatures_id() {
        return features_id;
    }

    public void setFeatures_id(int features_id) {
        this.features_id = features_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
