package com.qhx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qhx.domain.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BookDao extends BaseMapper<Book> {
     @Insert("insert into tbl_book (id,name,type,description) values (null,#{name},#{type},#{description})")
    Integer save( Book book);
}
