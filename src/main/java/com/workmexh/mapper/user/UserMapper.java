package com.workmexh.mapper.user;
import com.workmexh.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserMapper {
        //增加
        Integer insertUser(User user);
        //删除
        Integer deleteUser(User user);
        Integer deleteUserReNum(User user);
        //更新
        Integer updateUser(User user);
        //查询单个
        User findUser(User user);
        //查询所有
        List<User> findAllUsers();
}


