package com.blogsys.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blogsys.boot.bean.blogtype;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper extends BaseMapper<blogtype> {
}
