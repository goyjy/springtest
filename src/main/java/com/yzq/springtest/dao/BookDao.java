package com.yzq.springtest.dao;

import com.yzq.springtest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Integer> {
}
