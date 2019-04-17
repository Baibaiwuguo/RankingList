package com.wlxh.just.model;

public class ScoreFlow {
    private Integer id;

    private Integer score;

    private Integer userId;

    private String username;

    public ScoreFlow(Integer score, Integer userId, String username) {
        this.score = score;
        this.userId = userId;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}