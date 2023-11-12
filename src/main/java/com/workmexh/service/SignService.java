package com.workmexh.service;

import com.workmexh.domain.Regiact;
import com.workmexh.domain.Sign;
import com.workmexh.mapper.home.RegiMapper;
import com.workmexh.mapper.home.SignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SignService {
    @Autowired
    private SignMapper signMapper;

    public List<Sign> getSignNumberUser(Integer recNumber){
        return signMapper.getSignNumberUser(recNumber);
    }
    public int doSignAct(Sign sign){
        return signMapper.doSignAct(sign);
    }

}
