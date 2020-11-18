package com.nicestars.springboot.controller;

import com.nicestars.springboot.bean.BaseReponse;
import com.nicestars.springboot.bean.User;
import com.nicestars.springboot.service.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {


    private final Map map = new HashMap();
    @Autowired
    private UserServiceimpl userServiceimpl;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userServiceimpl.findAll();
    }

    //查
    @RequestMapping(value = "/findUserByProvince.do", method = RequestMethod.GET)
    public List<User> findUserByProvince(@RequestParam(value = "address") String address) {
        return userServiceimpl.findUserByProvince(address);
    }

    //增
    @RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
    public Map insertUser(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age, @RequestParam(value = "address") String address) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setAddress(address);
        //这里返回数据可以用两个方式来实现
        BaseReponse reponse = new BaseReponse();
//        if (userServiceimpl.insert(user)>1){
//            reponse.setCode(200);
//            reponse.setStatus("插入成功");
//            reponse.setSuccess(true);
//        }else {
//            reponse.setCode(300);
//            reponse.setStatus("插入失败");
//            reponse.setSuccess(false);
//        }
        if (userServiceimpl.insert(user) > 0) {
            map.put("code", 200);
            map.put("status", "插入成功");
            map.put("success", true);
        } else {
            map.put("code", 300);
            map.put("status", "插入失败");
            map.put("success", false);
        }
        return map;

    }

    //删
    @RequestMapping(value = "/deleteUserById.do", method = RequestMethod.POST)
    public Map deleteUserById(@RequestParam(value = "id") int id) {
        if (userServiceimpl.deleteUser(id) > 0) {
            map.put("code", 200);
            map.put("status", "删除成功");
            map.put("success", true);
        } else {
            map.put("code", 300);
            map.put("status", "删除失败");
            map.put("success", false);
        }
        return map;
    }

    //改
    @RequestMapping(value = "/update.do", method = RequestMethod.POST)
    public Map updateById(@RequestParam(value = "id") int id, @RequestParam(value = "name") String name, @RequestParam(value = "age") int age, @RequestParam(value = "address") String address) {
        if (userServiceimpl.updateById(id, name, age, address) > 0) {
            map.put("code", 200);
            map.put("status", "修改成功");
            map.put("success", true);
        } else {
            map.put("code", 300);
            map.put("status", "修改失败");
            map.put("success", false);
        }
        return map;
    }

}


//增删改  2020



