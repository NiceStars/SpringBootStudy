package com.nicestars.springboot.service;

import com.nicestars.springboot.bean.User;
import com.nicestars.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> findAll() {
        return mapper.findAll();
    }

    @Override
    public List<User> findUserByProvince(String address) {
        return mapper.findUserByProvince(address);
    }

    @Override
    public int insert(User user) {
        return mapper.insert(user);
    }

    @Override
    public int deleteUser(int id) {
        return mapper.deleteUser(id);
    }

    @Override
    public int updateById(int id, String name, int age, String address) {
        return mapper.updateById(id, name, age, address);
    }


}