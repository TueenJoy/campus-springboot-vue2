package com.workmexh.controller;

import com.workmexh.domain.News;

import com.workmexh.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/News")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @ResponseBody
    @RequestMapping("/showNewslist")
    public Map<String, Object> showNewslist(){
        List<News> newslist=newsService.showList();
        Map<String,Object> map=new HashMap<>();
        map.put("newslist",newslist);
        return map;
    }

    @ResponseBody
    @RequestMapping("/showListByType/{listType}")
    public Map<String, Object> showListByType(@PathVariable Integer listType){
        List<News> newslist=newsService.showListByType(listType);
        Map<String,Object> map=new HashMap<>();
        map.put("newslist",newslist);
        return map;
    }

    @ResponseBody
    @RequestMapping("/toNewsDetail/{listNumber}")
    public News toNewsDetail(@PathVariable Integer listNumber){
        News news=newsService.getDetailByListNumber(listNumber);
        return news;
    }

}
