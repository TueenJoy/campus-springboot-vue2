package com.workmexh.mapper.home;

import com.workmexh.domain.Sign;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SignMapper {
    // 通过signNumber查询报名了该活动的用户列表
    List<Sign> getSignNumberUser(Integer recNumber);

    // 用户报名活动 执行sign_act增加
    Integer doSignAct(Sign sign);

}
