package com.yzq.springtest.service.impl;

import com.yzq.springtest.dao.BookDao;
import com.yzq.springtest.entity.Book;
import com.yzq.springtest.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookDao.save(book);
    }

    @Override
    public void delete(Integer id) {
        bookDao.deleteById(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findOne(Integer id) {
        return bookDao.getOne(id);
    }
}
