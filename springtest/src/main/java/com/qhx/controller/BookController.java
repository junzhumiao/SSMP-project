package com.qhx.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qhx.controller.util.Code;
import com.qhx.controller.util.Rest;
import com.qhx.domain.Book;
import com.qhx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private Rest rest;

    @GetMapping
    public Rest getAll(){
        List<Book> list = bookService.list();
        rest.setCode(list.size() > 0 ? Code.OK :Code.ERR);
        rest.setData(list);
        return rest;
    }

    @PostMapping
    public Rest save(@RequestBody Book book){
        Boolean save = bookService.save1(book);
        rest.setData(save);
        rest.setCode(save ? Code.OK :Code.ERR);
        return rest;
    }

    @PutMapping
    public Rest update(@RequestBody Book book){
        Boolean update = bookService.update(book);
        rest.setCode(update ? Code.OK :Code.ERR);
        rest.setData(update);
        return rest;

    }

    @DeleteMapping("{id}")
    public Rest delete(@PathVariable Integer id){
        Boolean delete = bookService.delete(id);
        rest.setData(delete);
        rest.setCode(delete ? Code.OK :Code.ERR);

        return rest;
    }

    @GetMapping("{id}")
    public Rest RestetById(@PathVariable Integer id){
        Book byId = bookService.getById(id);
        rest.setData(byId);
        rest.setCode(byId != null ? Code.OK :Code.ERR);

        return  rest;
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Rest getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize, book);
        rest.setData(page);
        rest.setCode(page.getSize() > 0 ? Code.OK : Code.ERR);
        return rest;
    }
}
