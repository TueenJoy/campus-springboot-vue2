package com.workmexh.mapper.login;

import com.workmexh.domain.Login;
import com.workmexh.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginMapper {
    //登录
    Login userLogin(Login login);
    //注册
    Integer userRegister(User user);
    //注册查询账号是否重复
    Integer userRegisterNorepeat(String userAcc);
    //更改密码
    Integer userNewpwd(Login login);
    //忘记密码
    Login userMisspwd(User user);
    //重置密码并保存
    Integer userNewpwdSave(String userAcc,String newWord1);
    //更改个人信息
    Integer userChange(User user);
    //通过手机号查询邮箱
    String usergetEmail(String userAcc,String userMobile);
}
