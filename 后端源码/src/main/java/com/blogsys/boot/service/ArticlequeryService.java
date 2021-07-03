package com.blogsys.boot.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blogsys.boot.bean.article;
import com.blogsys.boot.mapper.AriticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*服务层
* 查询文章数据库的服务*/

@Service
public class ArticlequeryService {
    @Autowired
//  这里显示红线或者提示错误不用管它
    AriticleMapper ariticleMapper;

    private final int articles_page_size = 4;
    private long articles_total_counts;
    private long articles_page_counts;

    /* 文章查询服务初始化,用于确定文章总数和文章查询总页数
       输入值:null
       返回值:void */
    public void InquireInit(){
        Page<article> page = new Page<>(1, articles_page_size);
        Page<article> pageParam = ariticleMapper.selectPage(page, null);
        articles_total_counts = pageParam.getTotal();
        articles_page_counts = pageParam.getPages();
    }

    /* 查询首页
       该方法在页面加载时就会执行，由此设置页面的数量、记录的数量
       返回值:文章分页查询记录列表 */
    public List<article>  InquireFirstPage(){
        Page<article> page = new Page<>(1, articles_page_size);
        QueryWrapper<article> wrapper = Wrappers.query();
        wrapper.orderByDesc("id");
        Page<article> pageParam = ariticleMapper.selectPage(page, wrapper);
        return pageParam.getRecords();
    }

    /* 查询指定页码
    *  该方法在页面点击相应的页码选择的时候执行
    *  返回值:指定页码的分页查询记录列表 */
    public List<article>  Inquire_PageIndex(long page_index){
        if(page_index > articles_page_counts)page_index=1;
        if(page_index < 0)page_index=1;
        QueryWrapper<article> wrapper = Wrappers.query();
        wrapper.orderByDesc("id");
        Page<article> page = new Page<>(page_index, articles_page_size);
        Page<article> pageParam = ariticleMapper.selectPage(page, wrapper);
        return pageParam.getRecords();
    }

    /* 查询指定文章ID
    * 该方法在页面中被点击文章时执行
    * 返回值:相应ID的文章的记录信息 */
    public article  Inquire_ID(int article_id){
        if(article_id > articles_total_counts)article_id=1;
        if(article_id < 0)article_id=1;
        /* 获取之前的点击量，并更新点击量加一 */
        int pass_clicktime = ariticleMapper.selectById(article_id).getClicktimes();
        article a = new article();
        a.setId(article_id);
        a.setClicktimes(pass_clicktime+1);
        ariticleMapper.updateById(a);
        /* 返回指定文章查询 */
        return ariticleMapper.selectById(article_id);
    }

    /* 按照Type进行分页查询
     * 该方法在页面中被点击分类中指定Type时执行
     * 返回值:相应符合Type的文章的记录信息列表 */
    public Map<String, Object>  InquireByType(String article_type, int PageIndex){
        int query_type_page_size = 8;//设定每次对Type查询分页尺寸为4
        Page<article> page = new Page<>(PageIndex, query_type_page_size);
        QueryWrapper<article> wrapper = Wrappers.query();   //创建Wrapper条件构造器
        wrapper.like("type", article_type);   //设置Wrapper条件构造器
        wrapper.orderByDesc("id");
        Page<article> pageParam = ariticleMapper.selectPage(page, wrapper);
        Map<String,Object> PostQueryTypeRes = new HashMap<>();
        try{
            PostQueryTypeRes.put("PostList",pageParam.getRecords());
            PostQueryTypeRes.put("MaxPageIndex",pageParam.getPages());
        }
        catch(Exception e){
            System.out.println("按照Tags查询文章执行数据转化出现错误");
        }
        return PostQueryTypeRes;
    }

    /* 按照tags进行分页查询
     * 该方法在页面中被点击分类中指定Tags时执行
     * 返回值:相应符合Tags的文章的记录信息列表 */
    public Map<String, Object>  InquireByTags(String article_tags, int PageIndex){
        int query_type_page_size = 8;//设定每次对tags查询分页尺寸为4
        Page<article> page = new Page<>(PageIndex, query_type_page_size);
        QueryWrapper<article> wrapper = Wrappers.query();   //创建Wrapper条件构造器
        wrapper.like("tags", article_tags);   //设置Wrapper条件构造器
        wrapper.orderByDesc("id");
        Page<article> pageParam = ariticleMapper.selectPage(page, wrapper);
        Map<String,Object> PostQueryTagsRes = new HashMap<>();
        try{
            PostQueryTagsRes.put("PostList",pageParam.getRecords());
            PostQueryTagsRes.put("MaxPageIndex",pageParam.getPages());
        }
        catch(Exception e){
            System.out.println("按照Tags查询文章执行数据转化出现错误");
        }
        return PostQueryTagsRes;
    }

    /*获取总页数*/
    public long getArticles_page_counts(){
        return this.articles_page_counts;
    }

    /*获取总文章数*/
    public long getAarticles_total_counts(){
        return this.articles_total_counts;
    }

    /* 增加一条新的记录
    * 该方法在后台管理系统中选择部署时执行
    * 返回值增加的文章记录的ID*/
    public int InsertArticle(article new_article){
        ariticleMapper.insert(new_article);
        QueryWrapper<article> wrapper = Wrappers.query();
        wrapper.like("name", new_article.getName());
        return ariticleMapper.selectOne(wrapper).getId();
    }
}
