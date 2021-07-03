package com.blogsys.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blogsys.boot.bean.tags;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper extends BaseMapper<tags> {
}
