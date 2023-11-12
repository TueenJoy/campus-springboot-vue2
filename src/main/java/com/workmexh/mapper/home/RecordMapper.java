package com.workmexh.mapper.home;

import com.workmexh.domain.Record;
import com.workmexh.domain.Regiact;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RecordMapper {
    //
//    int doSignup(Integer actNumber,String userAcc);
    // 记录增加
    Integer dosignuptest(Record record);

    /*
    *   @Param userAcc(String)
    *   select record_act where recuseracc=
    *   to get regiNumber
    *   查找用户账号获取用户下已发布的文章
    *
    * */
    List<Record> selectUserAct(String userAcc);
    /*
    *   @Param recNumber(Integer)
    *   不同命名的 Regiact getNumbertoselect(Integer regiNumber);
    * */
    List<Regiact> getNumberSelect(Integer recNumber);
    /*
    *
    *   @Param recNumber(Integer)
    *
    * */
//    List<Record> selectNumberUser(Integer recNumber);


}
