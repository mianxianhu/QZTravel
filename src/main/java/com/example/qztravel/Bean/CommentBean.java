package com.example.qztravel.Bean;

public class CommentBean {
    private int id;
    private String username;
    private String comment;
    private String date;

    public CommentBean() {
    }

    public CommentBean(int id, String username, String comment, String date) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.date = date;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}