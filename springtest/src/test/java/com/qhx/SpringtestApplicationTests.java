package com.qhx;

import com.qhx.dao.BookDao;
import com.qhx.domain.Book;
import com.qhx.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot04JunitApplicationTests {
    //注入你要测试的对象,不对，卧槽，怎么说呢？查询包装器.....
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setType("机");
        book.setName("机");
        book.setDescription("机");
        bookService.getPage(1,2,book);
    }

    @Test
    void add(){
        Book book = new Book();
        book.setType("qhx");
        book.setName("qhx");
        book.setDescription("qhx");
        bookService.save1(book);

    }
}