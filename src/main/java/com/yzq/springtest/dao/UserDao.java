package com.yzq.springtest.dao;

import com.yzq.springtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDao extends JpaRepository<User, Integer> {

}
