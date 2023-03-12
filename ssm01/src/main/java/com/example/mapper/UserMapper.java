package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    User findUser(String name, String password);

    List<User> findAllUser();
}
