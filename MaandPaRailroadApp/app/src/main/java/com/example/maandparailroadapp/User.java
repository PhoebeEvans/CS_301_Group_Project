package com.example.maandparailroadapp;

import java.util.ArrayList;
import java.util.List;

public class User {

    // Attributes
    private String username;
    private String email;
    private String password;
    private int isAdmin;

    public User(String _username, String _email, String _password, int _isAdmin){
        this.username = _username;
        this.email = _email;
        this.password = _password;
        this.isAdmin = _isAdmin;
    }
    public List<String> getInfo(){
        List<String> values = new ArrayList<>();
        values.add(username);
        values.add(email);

        return values;
    }

    public void updateUser(String _username, String _email, String _password){
        this.email = _email;
        this.username = _username;
        this.password = _password;
    }

    public void makeAdmin(){
        this.isAdmin = 1;
    }

    public void removeAdmin(){
        this.isAdmin = 0;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getEmail() { return email; }

    public int getIsAdmin() { return isAdmin; }

}
