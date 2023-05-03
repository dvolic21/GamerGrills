package database;

import java.sql.Date;

public class User {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String zip;
    private String country;
    private Date date_created;
    private int role_key;

    public User() {

        this.username = "";
        this.password = "";
        this.firstName = "";
        this.lastName = "";
        this.phone = "";
        this.email = "";
        this.address = "";
        this.city = "";
        this.zip = "";
        this.country = "";
        this.date_created = null;
        this.role_key = 0;
    }

    public User(String username, String password, String firstName, String lastName, String phone, String email,
            String address, String city, String zip, String country, Date date_created, int role_key) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.country = country;
        this.date_created = date_created;
        this.role_key = role_key;
       
    }

    // * * * TBD if it is going to be used * * *

    // public boolean authenticate(User otherUser) {
    // if ((this.email.equals(otherUser.getEmail()) ||
    // this.username.equals(otherUser.getUsername()))
    // && this.password.equals(otherUser.getPassword())) {
    // this.id = otherUser.getId();
    // this.username = otherUser.getUsername();
    // this.password = otherUser.getPassword();
    // this.firstName = otherUser.getFirstName();
    // this.lastName = otherUser.getLastName();
    // this.phone = otherUser.getPhone();
    // this.email = otherUser.getEmail();
    // this.zip = otherUser.getZip();
    // this.city = otherUser.getCity();
    // this.country = otherUser.getCountry();
    // this.date_created = otherUser.getDate_created();
    // this. = otherUser.get();
    // this.role_key = otherUser.getRole_key();
    // return true;
    // } else
    // return false;
    // }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public int getRole_key() {
        return role_key;
    }

    public void setRole_key(int role_key) {
        this.role_key = role_key;
    }

}
