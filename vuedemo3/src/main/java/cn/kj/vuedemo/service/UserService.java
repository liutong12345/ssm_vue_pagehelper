package cn.kj.vuedemo.service;


import cn.kj.vuedemo.domain.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    User findById(Integer id);
    void updateUser(User user);
}
