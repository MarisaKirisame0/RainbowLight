package com.blogsys.boot.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("friendlink")
public class friendlink {
    @TableId
    private int id;
    private String name;
    private String url;
    private String info;
    private String content;
    private String avatar;
}
