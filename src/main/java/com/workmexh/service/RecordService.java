package com.workmexh.service;

import com.workmexh.domain.Record;
import com.workmexh.domain.Regiact;
import com.workmexh.mapper.home.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecordService {
    @Autowired
    private RecordMapper recordMapper;

//    public int doSignup(Integer actNumber,String userAcc){
//        return recordMapper.doSignup(actNumber,userAcc);
//    }
    public Integer dosignuptest(Record record){
        return recordMapper.dosignuptest(record);
    }
    public List<Record>  selectUserAct(String userAcc){
      return recordMapper.selectUserAct(userAcc);
    }
    public List<Regiact> getNumberSelect(Integer recNumber){
        return recordMapper.getNumberSelect(recNumber);
    }


}
