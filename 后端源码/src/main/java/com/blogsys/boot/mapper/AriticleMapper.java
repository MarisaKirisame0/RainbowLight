package com.blogsys.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blogsys.boot.bean.article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AriticleMapper extends BaseMapper<article> {
}
