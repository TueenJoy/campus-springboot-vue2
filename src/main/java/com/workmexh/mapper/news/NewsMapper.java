package com.workmexh.mapper.news;

import com.workmexh.domain.News;
import com.workmexh.domain.Regiact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface NewsMapper {


        //查询所有
        List<News> showList();
        // 查询不同类型的文章
        List<News> showListByType(Integer listType);
//        通过listNumber查看详情
News getDetailByListNumber(Integer listNumber);

    }
