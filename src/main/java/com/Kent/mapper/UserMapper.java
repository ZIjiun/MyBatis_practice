package com.Kent.mapper;

import com.Kent.pojo.User;

import java.util.List;

public interface UserMapper {

    // 返回類型是 List<User>
    List<User> selectAll();
}

