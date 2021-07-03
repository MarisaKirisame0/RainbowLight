package com.blogsys.boot.service;

import com.blogsys.boot.bean.tags;
import com.blogsys.boot.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagqueryService {
    @Autowired
    TagMapper tagMapper;

    /*查询所有的标签
    * 返回值:所有标签列表*/
    public List<tags> AllBlogTags(){
        return tagMapper.selectList(null);
    }
}
