package com.wlxh.just.dao;

import com.wlxh.just.model.UserScore;

import java.util.List;

public interface UserScoreMapper {
    UserScore selById(Integer id);
    int updById(UserScore userScore);
    int insUserScore(UserScore userScore);
    List<UserScore> selAll();
}