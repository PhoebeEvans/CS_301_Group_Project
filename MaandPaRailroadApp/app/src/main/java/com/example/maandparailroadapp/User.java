package com.example.maandparailroadapp;

import java.util.ArrayList;
import java.util.List;

public class User {

    // Attributes
    private String username;
    private String email;
    private String password;
    private boolean isAdmin;

    public User(String _username, String _email, String _password, boolean _isAdmin){
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
        this.isAdmin = true;
    }

    public void removeAdmin(){
        this.isAdmin = false;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

}
