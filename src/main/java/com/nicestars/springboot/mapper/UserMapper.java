package com.nicestars.springboot.mapper;

import com.nicestars.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    List<User> findAll();

    List<User> findUserByProvince(String address);

    int insert(User user);

    int deleteUser(int id);

    int updateById(int id, String name, int age, String address);
}