package com.example.todolistemgproject;

public class user {
    int id_user;
    String name_user;
   String mdp_user;

    public String getMdp_user() {
        return mdp_user;
    }

    public void setMdp_user(String mdp_user) {
        this.mdp_user = mdp_user;
    }

    public user(String mdp_user, String name_user) {
        this.mdp_user = mdp_user;
        this.name_user = name_user;
    }
    public user(){}

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }
}
