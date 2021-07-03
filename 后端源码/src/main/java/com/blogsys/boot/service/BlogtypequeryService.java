package com.blogsys.boot.service;

import com.blogsys.boot.bean.blogtype;
import com.blogsys.boot.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogtypequeryService {
    @Autowired
    TypeMapper typeMapper;

    /*查询所有的类型
    * 返回值:所有类型列表*/
    public List<blogtype> AllBlogTypes(){
        return typeMapper.selectList(null);
    }
}
