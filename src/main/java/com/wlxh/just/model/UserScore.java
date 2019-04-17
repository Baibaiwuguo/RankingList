package com.wlxh.just.model;

public class UserScore {
    private Integer id;

    private Integer userId;

    private Integer userScore;

    private String name;

    public UserScore(Integer userId, Integer userScore, String name) {
        this.userId = userId;
        this.userScore = userScore;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserScore() {
        return userScore;
    }

    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}