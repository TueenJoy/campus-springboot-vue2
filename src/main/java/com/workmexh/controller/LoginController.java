package com.workmexh.controller;
import com.workmexh.common.MailUtils;
import com.workmexh.common.UserSetName;
import com.workmexh.common.commonDomain.mailJson;
import com.workmexh.domain.Login;
import com.workmexh.domain.User;
import com.workmexh.mapper.login.LoginMapper;
import com.workmexh.mapper.user.UserMapper;
import com.workmexh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import com.workmexh.domain.properties.RespBean;
// HttpServletRequest request

/*
*
* 控制类 登录页
* 包含 登录、注册、更新、查询、忘记密码、邮箱发送功能实现
*
* */

@Controller

@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private LoginMapper loginMapper;
    @Autowired
    private MailUtils mailUtils;
    @Value("${spring.mail.username}")
    private String mailto;
    // 初始化验证码以及手机号
    String glouserAcc=null;
    String glouserMobile=null;
    String glonums=null;
    //登录 返回所有信息

//
//    @ResponseBody
//    @RequestMapping("/Login")
//    public Object login(@RequestBody User user){
//       user.getUserAcc();
//       user.getUserPassword();
//       user=userMapper.findUser(user);
//        Object[] obj=new Object[]{};
//        ArrayList<Object> userObj = new ArrayList<Object>(Arrays.asList(obj));
//        userObj.add(user);
//        System.out.println("登录结果："+userObj);
//
//        return userObj;
//    }
//    //登录 只返回账号、密码、用户名
//    @ResponseBody//    @RequestMapping("/LoginMapper")
//    public Object userLogin(@RequestBody Login login){
//        login.getUserAcc();
//        login.getUserPassword();
//        login=loginMapper.userLogin(login);
//        Object[] obj=new Object[]{};
//        ArrayList<Object> userObj = new ArrayList<Object>(Arrays.asList(obj));
//        userObj.add(login);
//        System.out.println("登录结果："+login);
//        return userObj;
////        return loginService.userLogin(login);
//    }
    //登录 只返回账号、密码、用户名
    @ResponseBody
    @RequestMapping("/LoginMapper")
    public Object userLogin(@RequestBody Login login){
        System.out.println("登录结果："+loginService.userLogin(login));
        Login loginRes=loginService.userLogin(login);
        if (loginRes==null){
            return new RespBean("404","登录失败",null);
        }else{
            return new RespBean("200","登录成功！",loginRes.getUserName());
        }

    }
    // 注册 返回1成功 返回0失败
//    @ResponseBody
//    @RequestMapping("/Register")
//    public int userRegister(@RequestBody User user){
//        user.getUserAcc();
//        user.getUserPassword();
//        user.getUserName();
//        System.out.println("用户填写的信息："+user);
//        String userAcc= user.getUserAcc();
//        int regRes=loginMapper.userRegiste rNorepeat(userAcc);
//        System.out.println(regRes);
//        int num=0;
//        if(regRes==0){
//            num=loginMapper.userRegister(user);
//            System.out.println("注册结果："+num);
//        }else{
//            System.out.println("用户名已被使用："+num);
//        }
//        return num;
//    }
    @ResponseBody
    @RequestMapping("/Register")
    public int userRegister(@RequestBody User user){
        System.out.println("用户填写的账号："+user);
        String userAcc= user.getUserAcc();
        int regRes=loginService.userRegisterNorepeat(userAcc);
        System.out.println(regRes);
        int num=0;
        if(regRes==0){
            num=loginService.userRegister(user);
            System.out.println("注册结果："+num);
        }else{
            System.out.println("账号已被注册："+num);
        }
        return num;
    }
    // 修改信息
    @ResponseBody
    @RequestMapping("/Change")
    public int userChange(@RequestBody User user){
        int num=loginService.userChange(user);
        System.out.println("更新信息结果："+num);
        return num;
    }
    // 更改密码
    @ResponseBody
    @RequestMapping("/Newpwd")
    public int userNewpwd(@RequestBody Login login){

        int num=loginService.userNewpwd(login);
        System.out.println("更改密码结果："+num);
        return num;
    }
    // 忘记密码
    /*
    填写账号和手机号后，点击获取验证码
    post->Misspwd 查询账号与手机号的对应关系
    post->Misspwd-submit 构建mailJson实例
    调用common-UserSetName方法 获取4位数验证码
    mailto获取loginMapper-usergetEmail返回的邮箱
    收到邮件进行最后验证
    *
    */
    @ResponseBody
    @RequestMapping("/Misspwd")
    public Login userMisspwd(@RequestBody User user){
        Login login=new Login();
        login.setUserAcc(user.getUserAcc());
        login.setUserMobile(user.getUserMobile());
        glouserAcc=user.getUserAcc();
        login=loginService.userMisspwd(user);
        System.out.println("找回密码查询用户："+login);
        return login;
    }
    @ResponseBody
    @RequestMapping("/Misspwd-submit")
    public Object userMisspwd(@RequestBody mailJson mailJson){
        UserSetName userSetName=new UserSetName();
        String nums=userSetName.setName(4);
        mailJson.getUserMobile();
        mailJson.setNums(nums);
        Object[] obj=new Object[]{};
        ArrayList<Object> numsObj = new ArrayList<Object>(Arrays.asList(obj));
        numsObj.add(mailJson);
        System.out.println("即将返回给前端的信息："+mailJson);
        glouserMobile=null;
        glonums=null;
        glouserMobile=mailJson.getUserMobile();
        glonums=mailJson.getNums();
        mailto=loginService.usergetEmail(glouserAcc,glouserMobile);
        mailUtils.sendSimpleEmail(mailto,"账户密码重置","验证码："+glonums);
        return numsObj;
    }
    @ResponseBody
    @RequestMapping("/Misspwd-submit-nums")
    public int submitNums(@RequestBody mailJson mailJson){
       String nums=mailJson.getNums();
        System.out.println("用户填写的验证码："+nums);
        System.out.println("进行校验的验证码："+glonums);
        /*
        res:
        0 表示成功验证
        1 表示已获得验证码但验证码错误
        2 表示未获取验证码
        */
        int res = 1;
        if(glonums!=null){
            if(nums.equals(glonums)){
                res=0;
                System.out.println("验证码正确");
            }else{
                res=1;
                System.out.println("验证码错误");
            }
        }else{
            res=2;
            System.out.println("用户未点击获取验证码");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/Misspwd-submit-save")
    public int submitSave(@RequestBody Login login){
        String newWord=login.getUserPassword();
        int res=loginService.userNewpwdSave(glouserAcc,newWord);
        System.out.println("新密码："+newWord);
        System.out.println(res);
        return res;
    }
}

