package com.example.agriai;

public class FeedbackDetails {

    private int id;
    private String username, email, feedback;

    public FeedbackDetails(int id, String username, String email, String feedback) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.feedback = feedback;
    }

    public FeedbackDetails(String username, String email, String feedback) {
        this.username = username;
        this.email = email;
        this.feedback = feedback;
    }

    public FeedbackDetails(AddFeedback addFeedback) {

    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
