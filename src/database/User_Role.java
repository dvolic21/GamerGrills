package database;

public class User_Role {
    private int user_role_id;
    private int role_id;
    private int user_id;
    public User_Role(int user_role_id, int role_id, int user_id) {
        this.user_role_id = user_role_id;
        this.role_id = role_id;
        this.user_id = user_id;
    }
    public int getUser_role_id() {
        return user_role_id;
    }
    public void setUser_role_id(int user_role_id) {
        this.user_role_id = user_role_id;
    }
    public int getRole_id() {
        return role_id;
    }
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    
}
