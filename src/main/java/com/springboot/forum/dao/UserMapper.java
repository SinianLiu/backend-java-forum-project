package com.springboot.forum.dao;

import com.springboot.forum.entity.User;
import org.apache.ibatis.annotations.Mapper;


//Mapper是mybatis的注解
//repository才是springboot的
@Mapper
public interface UserMapper {
    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String email);

    int insertUser(User user);

    int updateStatus(int id, int status);

    int updateHeader(int id, String headerUrl);

    int updatePassword(int id, String password);
}
