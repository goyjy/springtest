package com.yzq.springtest.service;

import com.yzq.springtest.entity.Book;

import java.util.List;

public interface BookService {

    //保存
    public Book save(Book book);
    //更新
    public Book update(Book book);
    //删除
    public void delete(Integer id);
    //查询返回所有列表
    public List<Book> findAll();
    //查询一条记录
    public Book findOne(Integer id);


}
