package com.workmexh.service;


import com.workmexh.domain.News;
import com.workmexh.domain.Regiact;
import com.workmexh.mapper.news.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class NewsService {

    @Autowired
    private NewsMapper newsMapper;
    public List<News> showList(){
        return newsMapper.showList();
    }
    public List<News> showListByType(Integer listType){
        return newsMapper.showListByType(listType);
    }
    public News getDetailByListNumber(Integer listNumber){
        return newsMapper.getDetailByListNumber(listNumber);
    }
}
