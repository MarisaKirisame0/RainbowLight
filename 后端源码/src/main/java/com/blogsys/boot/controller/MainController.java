package com.blogsys.boot.controller;

import com.blogsys.boot.bean.article;
import com.blogsys.boot.bean.friendlink;
import com.blogsys.boot.bean.tags;
import com.blogsys.boot.service.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    ArticlequeryService articlequeryService;
    @Autowired
    BlogtypequeryService blogtypequeryService;
    @Autowired
    TagqueryService tagqueryService;
    @Autowired
    MarkdownreaderService markdownreaderService;
    @Autowired
    FriendLinkService friendLinkService;

    /* 功能:APP组件进行最初始化的查询
    *  输入值:null
    *  返回值:long, 文章总数 */
    @GetMapping("/APP/InquirePostTotalCount")
    @CrossOrigin(origins = "*")
    public long AppInquire(){
        articlequeryService.InquireInit();
        return articlequeryService.getAarticles_total_counts();
    }

    /* 功能: 前端页面加载时 获取 第一页文章、总页数、总文章数
     * 输入值: null
     * 返回值：Map<String,Object>，第一个元素是文章列表:JSON数组, 第二个元素是总页数, 第三个元素是总文章数 */
    @GetMapping("/PageLoading/GetPageLordingInformation")
    @CrossOrigin(origins = "*")
    public Map<String,Object> PageLoading_GetPageLordingInformation(){
        List<article> res_article = articlequeryService.InquireFirstPage();  //分页查询获取文章列表。注意该方法必须执行，以确定总页数和总文章数。
        Map<String,Object> res = new HashMap<>();
        try{
            res.put("PostList",res_article);
            res.put("MaxPageIndex",articlequeryService.getArticles_page_counts());
            res.put("TotalPostCount",articlequeryService.getAarticles_total_counts());
            return res;
        }
        catch(Exception e){
           log.info("后端获取首页文章、类型、标签列表信息出现错误");
        }
        return null;
    }

    //获取第一页文章
    @GetMapping("/PageLoading/GetArticleInformationList")
    @CrossOrigin(origins = "*")
    public List<article> PageLoading_GetArticleInformationList(){
        return articlequeryService.InquireFirstPage();
    }

    //按照文章的id获取文章具体内容 前端得到HTML片段
    @GetMapping("/PageReading/GetArticleByID")
    @CrossOrigin(origins = "*")
    public String PageReading_GetArticleByID(@RequestParam("ArticleID") int id){
        return  markdownreaderService.MarkdownConvertHtml(articlequeryService.Inquire_ID(id).getAddress());
    }

    /* 功能：按照指定的页码获取分页查询文章列表
     * 输入值：long 页码值
     * 返回值：List<article> ,前端得到JSON数组，每个元素代表一个文章 */
    @GetMapping("/PageReading/GetArticleInformationListByPage")
    @CrossOrigin(origins = "*")
    public List<article> PageReading_GetArticleInformationListByPage(@RequestParam("AriticlesListPage") long pageindex){
        return articlequeryService.Inquire_PageIndex(pageindex);
    }

    /* 功能：按照指定ID查询文章，返回文章的信息与文章具体内容转化后的HTML片段
    *  输入值：long变量数字，是文章的ID
    *  返回值：Map<String,Object>，第一个元素是文章信息:JSON，第二个元素是文章内容转化的HTML片段:String */
    @GetMapping("/PageReading/GetArticleInfoByID")
    @CrossOrigin(origins = "*")
    public Map<String,Object> PageReading_GetArticleInfoByID(@RequestParam("ArticleID") int ArticleID){
        Map<String,Object> res = new HashMap<>();
        article ArticleInfo = articlequeryService.Inquire_ID(ArticleID);
        String ArticleContent = markdownreaderService.MarkdownConvertHtml(ArticleInfo.getAddress());
        try{
            res.put("Info",ArticleInfo);
            res.put("Content",ArticleContent);
            return res;
        }
        catch (Exception e){
            log.info("后端获取指定ID的文章信息时出现错误");
        }
        return null;
    }

    /* 功能：获取tags信息
     * 输入值：void
     * 返回值：List<tags> ,返回前端一个JSON数组，每个JSON代表一个标签 */
    @GetMapping("/PageReading/GetTagsInformation")
    @CrossOrigin(origins = "*")
    public List<tags> PageReading_GetTagsInformation(){
        return tagqueryService.AllBlogTags();
    }

    /* 功能：按照指定Type查询文章，返回文章列表与最大查询页数
     * 输入值：String:article_type 文章的Type, int:PageIndex 分页查询的页码
     * 返回值：Map<String,Object>，第一个元素是文章列表:JSON数组，第二个元素是查询最大页码:long */
    @GetMapping("/PageQuery/QueryTypeRecords")
    @CrossOrigin(origins = "*")
    public Map<String, Object> PageQuery_QueryTypeRecords(@RequestParam("Type") String article_type, @RequestParam("Index") int PageIndex){
        return articlequeryService.InquireByType(article_type,PageIndex);
    }


    /* 功能：按照指定Tags查询文章，返回文章列表与最大查询页数
     * 输入值：String:article_tags 文章的Tags, int:PageIndex 分页查询的页码
     * 返回值：Map<String,Object>，第一个元素是文章列表:JSON数组，第二个元素是查询最大页码:long */
    @GetMapping("/PageQuery/QueryTagsRecords")
    @CrossOrigin(origins = "*")
    public Map<String, Object> PageQuery_QueryTagsRecords(@RequestParam("Tags") String article_tags, @RequestParam("Index") int PageIndex){
        return articlequeryService.InquireByTags(article_tags, PageIndex);
    }

    /* 功能：获取友链信息
     * 输入值：void
     * 返回值：List，返回前端JSON数组，所有友链信息，每个JSON是一个友链 */
    @GetMapping("/PageReading/GetFriendLink")
    @CrossOrigin(origins = "*")
    public List<friendlink> PageReading_GetFriendLink(){
        return friendLinkService.AllFriendLink();
    }

    /* 功能：插入一条新的文章记录
     * 输入值：article 文章实例
     * 返回值：当前文章的ID */
    @PostMapping("/CRUD/AddPost")
    @CrossOrigin(origins = "*")
    public long CRUD_InsertArticle(@RequestBody @NotNull article new_article){
        new_article.setTime(new_article.getTime().split("T")[0]);
        return articlequeryService.InsertArticle(new_article);
    }
}
