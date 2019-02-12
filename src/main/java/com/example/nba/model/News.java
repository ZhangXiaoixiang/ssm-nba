package com.example.nba.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * news
 * @author 
 */
@Data//getset方法
@ToString//toString方法
@NoArgsConstructor//无参
public class News implements Serializable {
    /**
     * id
     */
    private Integer id;

    /**
     * 新闻时间
     */
    private Date newsDate;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻图片链接
     */
    private String picpath;

    /**
     * 新闻链接
     */
    private String newsUrl;

    /**
     * 新闻正文内容
     */
    private String newsContent;

    private static final long serialVersionUID = 1L;

    public News(Date newsDate, String newsTitle, String picpath, String newsUrl, String newsContent) {
        this.newsDate = newsDate;
        this.newsTitle = newsTitle;
        this.picpath = picpath;
        this.newsUrl = newsUrl;
        this.newsContent = newsContent;
    }

    public News(Integer id, Date newsDate, String newsTitle, String picpath, String newsUrl, String newsContent) {
        this.id = id;
        this.newsDate = newsDate;
        this.newsTitle = newsTitle;
        this.picpath = picpath;
        this.newsUrl = newsUrl;
        this.newsContent = newsContent;
    }
}