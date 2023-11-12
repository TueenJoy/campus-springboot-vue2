package com.workmexh.mapper.home;

import com.workmexh.domain.Regiact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RegiMapper {

    // test新增活动
    Integer doAddact(Regiact regiact);
    // 主页新增活动
//    Integer doRegi()
    // 新增活动 随机编号查重
    Integer doNorepeat(Integer regiNumber);
//    详情页 通过regiNumber获取数据库中对应的文章
    Regiact getNumbertoselect(Integer regiNumber);
}
