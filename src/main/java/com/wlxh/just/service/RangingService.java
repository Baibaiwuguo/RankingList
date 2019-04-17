package com.wlxh.just.service;


import com.wlxh.just.dao.ScoreFlowMapper;
import com.wlxh.just.dao.UserScoreMapper;
import com.wlxh.just.model.ScoreFlow;
import com.wlxh.just.model.UserScore;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author:baibaiwuchang
 * @Data:2019/4/17 14:54
 */
@Service
public class RangingService implements InitializingBean {

    private static final String SALESCORE = "sale_score_rank:";


    @Autowired
    private RedisService redisService;

    @Autowired
    private UserScoreMapper userScoreMapper;

    @Autowired
    private ScoreFlowMapper scoreFlowMapper;

    /**
     * 添加用户  和 积分
     * @param uid
     * @param score
     */
    public void AddScore(Integer uid,Integer score)
    {
        UserScore userScore=userScoreMapper.selById(uid);
        if (userScore == null)
        {
            return;
        }
        String name=userScore.getName();
        String key=uid+":"+name;
        Integer scoreall=score+userScore.getUserScore();
        scoreFlowMapper.insScoreFlow(new ScoreFlow(score,uid,name));
        userScoreMapper.updById(new UserScore(uid,scoreall,name));
        redisService.incrementScore(SALESCORE,key,score);
    }

    /**
     * 获取uid 用户的信息
     * @param uid
     * @param name
     * @return
     */
    public Map<String,Object> userRank(Integer uid,String name)
    {
        Map<String,Object> map=new LinkedHashMap<>();
        String key = uid+":"+name;
        Integer rank = redisService.zRank(SALESCORE,key).intValue();  //获取uid 用户的排名
        Integer score = redisService.zSetScore(SALESCORE,key).intValue(); //获取uid 用户的分数
        map.put("userId",uid);
        map.put("score",score);
        map.put("rank",rank);
        return map;
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public List<Map<String,Object>> reversezRankWithRank(Integer start,Integer end)
    {
        Set<ZSetOperations.TypedTuple<Object>> setobj = redisService.reverseZRankWithRank(SALESCORE,start,end);
        List<Map<String,Object>> maps=setobj.stream().map(objectTypedTuple -> {
            Map<String,Object> map=new LinkedHashMap<>();
            map.put("userId",objectTypedTuple.getValue().toString().split(":")[0]);
            map.put("userName",objectTypedTuple.getValue().toString().split(":")[1]);
            map.put("score",objectTypedTuple.getScore());
            return map;
        }).collect(Collectors.toList());
        return maps;
    }

    /**
     *
     * @param start
     * @param end
     * @return
     */
    public List<Map<String, Object>> zRankWithScore(Integer start, Integer end) {
        Set<ZSetOperations.TypedTuple<Object>> setObj = redisService.zRankWithScore(SALESCORE, start, end);
        List<Map<String, Object>> mapList = setObj.stream().map(objectTypedTuple -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("userId", objectTypedTuple.getValue().toString().split(":")[0]);
            map.put("userName", objectTypedTuple.getValue().toString().split(":")[1]);
            map.put("score", objectTypedTuple.getScore());
            return map;
        }).collect(Collectors.toList());
        return mapList;
    }

    /**
     * 初始化数据库数据到redis
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
       System.out.println("进入");
        List<UserScore> userScores = userScoreMapper.selAll();
        userScores.forEach(userScore -> {
            String key = userScore.getUserId() + ":" + userScore.getName();
            redisService.zAdd(SALESCORE, key, userScore.getUserScore());
        });
    }
}
