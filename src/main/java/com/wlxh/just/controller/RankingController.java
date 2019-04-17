package com.wlxh.just.controller;

import com.wlxh.just.service.RangingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:baibaiwuchang
 * @Data:2019/4/17 19:27
 */
@RestController
public class RankingController {
    @Autowired
    private RangingService rangingService;

    @RequestMapping(value = "/adduser")
    public Object adduser(Integer uid,Integer score)
    {
         rangingService.AddScore(uid,score);
        return  "success";
    }

    @RequestMapping(value = "/seluser")
    public Object seluser(Integer uid,String name)
    {
        return rangingService.userRank(uid,name);
    }

    @RequestMapping(value = "/uprank")
    public Object uprank(Integer start,Integer end)
    {
        return rangingService.zRankWithScore(start,end);
    }


    @RequestMapping(value = "/downrank")
    public Object downrank(Integer start,Integer end)
    {
        return rangingService.reversezRankWithRank(start,end);
    }


}
