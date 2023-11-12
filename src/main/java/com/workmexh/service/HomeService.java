package com.workmexh.service;

import com.workmexh.domain.User;
import com.workmexh.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HomeService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUsers(){
        return userMapper.findAllUsers();
    }
}
