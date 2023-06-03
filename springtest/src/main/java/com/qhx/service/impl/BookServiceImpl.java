package com.qhx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qhx.dao.BookDao;
import com.qhx.domain.Book;
import com.qhx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {
    @Autowired
    private BookDao bookDao;

    public Boolean save1(Book book) {
        return bookDao.save(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize,Book book) {
        // 扩展功能，包装器包装
        IPage page = new Page(currentPage,pageSize);
        LambdaQueryWrapper<Book> l = new LambdaQueryWrapper<>();
        l.like(Book::getName,book.getName());
        l.like(Book::getType,book.getType());
        l.like(Book::getDescription,book.getDescription());
        bookDao.selectPage(page,l);
        return page;
    }
}
