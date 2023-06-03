package com.qhx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qhx.domain.Book;

import java.util.List;

public interface BookService extends IService<Book> {
    /**
     * 保存
     *
     * @param
     * @return
     */

    Boolean save1(Book book);

    /**
     *修改
     *
     * @param
     * @return
     */

    Boolean update(Book book);

    /**
     *删除
     *
     * @param
     * @return
     */

    Boolean delete(Integer id);

    /**
     *查询指定
     *
     * @param
     * @return
     */

    Book getById(Integer id);

    /**
     *查询全部
     *
     * @param
     * @return
     */

    List<Book> getAll();

    /**
     *分页全部查询
     *
     * @param
     * @return
     */

    IPage<Book> getPage(int currentPage, int pageSize,Book book);
}
