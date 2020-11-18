package com.nicestars.springboot.service;

import com.nicestars.springboot.bean.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    List<User> findUserByProvince(String address);

    int insert(User user);

    int deleteUser(int id);

    int updateById(int id, String name, int age, String address);
}
