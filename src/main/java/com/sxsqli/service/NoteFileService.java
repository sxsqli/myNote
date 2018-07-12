package com.sxsqli.service;

import com.sxsqli.domain.NoteFile;
import com.sxsqli.mapper.NoteFileMapper;
import com.sxsqli.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NoteFileService {

    public List<NoteFile> findAll(){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
        NoteFileMapper noteFileMapper = sqlSession.getMapper(NoteFileMapper.class);
        List<NoteFile> all = noteFileMapper.findAll();
        sqlSession.close();
        return all;
    }

    public List<NoteFile> findLike(String like) {
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
        NoteFileMapper noteFileMapper = sqlSession.getMapper(NoteFileMapper.class);
        List<NoteFile> files = noteFileMapper.findLike("%"+like+"%");
        sqlSession.close();
        return files;
    }

    public void insert(NoteFile noteFile){
        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
        NoteFileMapper noteFileMapper = sqlSession.getMapper(NoteFileMapper.class);
        noteFileMapper.insert(noteFile);
        sqlSession.commit();
        sqlSession.close();
    }
}
