package com.workmexh.service;

import com.workmexh.domain.Record;
import com.workmexh.domain.Regiact;
import com.workmexh.mapper.home.RegiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegiService {
    @Autowired
    private RegiMapper regiMapper;

    public Integer doAddact(Regiact regiact){
        return regiMapper.doAddact(regiact);
    }

    public Integer doNorepeat(Integer regiNumber){
        return regiMapper.doNorepeat(regiNumber);
    }
    public Regiact getNumbertoselect(Integer regiNumber){
        return regiMapper.getNumbertoselect(regiNumber);
    }



}
