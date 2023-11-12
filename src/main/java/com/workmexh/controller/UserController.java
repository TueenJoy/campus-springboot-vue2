package com.workmexh.controller;
import com.workmexh.common.UserSetName;
import com.workmexh.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.workmexh.mapper.user.UserMapper;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/UserMapper")
public class UserController {
    @Resource
    private UserMapper userMapper;
    //添加用户 需要name acc psw
    @ResponseBody
    @RequestMapping("/addUser/userAcc={userAcc}/userPassword={userPassword}")
    public User addUser(@PathVariable String userAcc, @PathVariable String userPassword){
        UserSetName userSetName=new UserSetName();
        String userName=userSetName.setName(6);
        System.out.println(userName);
        User user=new User(null,userName,userAcc,userPassword);

        System.out.println(userMapper.insertUser(user));
        return user;
    }
    @ResponseBody
    @RequestMapping("/delUser/userAcc={userAcc}")
    public User delUser(@PathVariable String userAcc){
        User user=new User(userAcc);
        System.out.println(userMapper.deleteUser(user));
        return user;
    }
    //一次性返回两种类型的数据，结合了Map和list
    @ResponseBody
    @RequestMapping("/delUserReNum/userAcc={userAcc}")
    public List<Map> delUserReNum(@PathVariable String userAcc){
        Map<String, Integer> num = new HashMap<>();
        Map<String,User> users = new HashMap<>();
        // 定义两个map 1个存放受影响的行数 1个存放user
        User user=new User(userAcc);
        num.put("受影响行数",userMapper.deleteUserReNum(user));
        users.put("user",user);
        List<Map> list = new ArrayList<Map>();
        list.add(num);
        list.add(users);
        System.out.println(list);
        return list;
    }
    @ResponseBody
    @RequestMapping("/updateUser/userAcc={userAcc}/userName={userName}")
    public User updateUserByAcc(@PathVariable String userAcc, @PathVariable String userName){
        User user=new User(userAcc,userName);
        System.out.println(userMapper.updateUser(user));
        return user;
    }
    @ResponseBody
    @RequestMapping("/findUser/userAcc={userAcc}/userPassword={userPassword}")
    public User findUserByAcc(@PathVariable String userAcc, @PathVariable String userPassword){
        User user=new User();
        user.setUserAcc(userAcc);
        user.setUserPassword(userPassword);
        user=userMapper.findUser(user);
        System.out.println(user);
        return user;
    }
    @ResponseBody
    @RequestMapping("/findAllUsers")
    public List<User> findAllUsers(){
        List<User> user=userMapper.findAllUsers();
        for (User list : user) {
            System.out.println(list);
        }
        return user;
    }


}
