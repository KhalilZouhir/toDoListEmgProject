package com.example.todolistemgproject;

public class task {
    int id_task;
    String desc_task;
    int state_task;
    int id_user ;

    public int getId_task() {
        return id_task;
    }

    public void setId_task(int id_task) {
        this.id_task = id_task;
    }

    public String getDesc_task() {
        return desc_task;
    }

    public void setDesc_task(String desc_task) {
        this.desc_task = desc_task;
    }

    public int getState_task() {
        return state_task;
    }

    public void setState_task(int state_task) {
        this.state_task = state_task;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
