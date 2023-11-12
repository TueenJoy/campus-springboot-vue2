package com.workmexh.service;

import com.workmexh.domain.Regiact;

import com.workmexh.mapper.home.ActMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ActService {
    @Autowired
    private ActMapper actMapper;

    public List<Regiact> showList( ){
        return actMapper.showList();
    }


}
