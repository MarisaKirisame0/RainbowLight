package com.blogsys.boot.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("types")
public class blogtype {
    @TableId
    private int id;
    private String typename;
    private int usetimes;
    private String articles_id;
}
