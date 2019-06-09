package com.yzq.springtest.dao;

import com.yzq.springtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserNameDao extends JpaRepository<User, String> {

    public List<User> findByUsernameLike(String username);

}
