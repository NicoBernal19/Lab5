package com.example.servingwebcontent;

public class ToDo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public int getUserId(){
        return userId;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public boolean getCompleted(){
        return completed;
    }
}
