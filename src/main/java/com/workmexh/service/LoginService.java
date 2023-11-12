package com.workmexh.service;

import com.workmexh.domain.Login;
import com.workmexh.domain.User;
import com.workmexh.mapper.login.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;

    public Login userLogin(Login login){
        return loginMapper.userLogin(login);
    }

    public Integer userRegister(User user){
        return loginMapper.userRegister(user);
    }

    public Integer userRegisterNorepeat(String userAcc){
        return loginMapper.userRegisterNorepeat(userAcc);
    }

    public  Integer userNewpwd(Login login){
        return loginMapper.userNewpwd(login);
    }
    public  Integer userNewpwdSave(String userAcc,String newWord1){
        return loginMapper.userNewpwdSave(userAcc,newWord1);
    }
    public Login userMisspwd(User user){
        return loginMapper.userMisspwd(user);
    }

    public  Integer userChange(User user){
        return loginMapper.userChange(user);
    }
    public  String usergetEmail(String userAcc,String userMobile){
        return loginMapper.usergetEmail(userAcc, userMobile);
    }

}
