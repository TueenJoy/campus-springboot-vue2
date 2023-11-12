package com.workmexh.mapper.home;

import com.workmexh.domain.Regiact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ActMapper {
        //查询所有
        List<Regiact> showList();
        //



}
