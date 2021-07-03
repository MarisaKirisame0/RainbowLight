package com.blogsys.boot.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tags")
public class tags {
    @TableId
    private int id;
    private String tagname;
    private int usetimes;
    private String articles_id;
}
