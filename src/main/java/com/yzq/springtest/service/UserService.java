package com.yzq.springtest.service;

import com.yzq.springtest.entity.User;

import java.util.List;

public interface UserService  {
    //保存
    public User save(User user);
    //更新
    public User update(User user);
    //删除
    public void delete(Integer id);
    //查询返回所有列表
    public List<User> findAll();
    //查询一条记录
    public User findOne(Integer id);

    public List<User> findByUsernameLike(String username);

    public User findByUsername(String username);
}
