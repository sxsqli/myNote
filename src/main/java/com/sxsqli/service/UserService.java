package com.sxsqli.service;

import com.sxsqli.domain.NoteFile;
import com.sxsqli.domain.User;
import com.sxsqli.mapper.NoteFileMapper;
import com.sxsqli.mapper.UserMapper;
import com.sxsqli.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserService {
    public User checkUser(String username,String password){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List<User> users = userMapper.findByUser(user);
        sqlSession.close();
        if(users.size()==1){
            return users.get(0);
        }
        return null;
    }
}
