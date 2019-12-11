package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String username;
    private String feeling;
    private List<String> friends;

    public User() {

    }

    public User(String id, String username, String feeling) {
        this.id = id;
        this.username = username;
        this.feeling = feeling;
        this.friends = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeeling() {
        return feeling;
    }

    public void setFeeling(String feeling) {
        this.feeling = feeling;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
