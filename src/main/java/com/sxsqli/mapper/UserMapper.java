package com.sxsqli.mapper;

import com.sxsqli.domain.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);
    int delete(User user);
    int update(User user);
    List<User> findAll();
    List<User> findByUser(User user);
}
