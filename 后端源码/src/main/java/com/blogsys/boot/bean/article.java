package com.blogsys.boot.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("articles")
public class article {
    @TableId
    private int id;
    private String name;
    private String address;
    private String time;
    private String type;
    private String tags;
    private int clicktimes;
    private String cover;
    private String introduction;
}
