package com.blogsys.boot.service;

import com.blogsys.boot.bean.friendlink;
import com.blogsys.boot.mapper.FriendLinkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendLinkService {
    @Autowired
    FriendLinkMapper friendLinkMapper;

    /* 用途：获取友链数据库中所有的友链数据
    *  返回值：以各个friendlink的JavaBean风格类为元素的List，即List中是JSON数据元素，每个元素是一个友链
    *  */
    public List<friendlink> AllFriendLink(){
        return friendLinkMapper.selectList(null);
    }
}
