package com.asgarov.spring_jdbc.dao;

import com.asgarov.spring_jdbc.entity.Singer;

import java.util.List;

public interface SingerDao {
    List<Singer> findAll();

    void insert(Singer singer);

    void delete(Long singerId);
}
