package database;

public class Role {
    private int role_id;
    private String role;
    private String description;

    public Role(int role_id, String role, String description) {
        this.role_id = role_id;
        this.role = role;
        this.description = description;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
