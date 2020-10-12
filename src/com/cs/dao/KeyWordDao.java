package com.cs.dao;

import com.cs.entity.KeyWord;

import java.util.List;

public interface KeyWordDao {
    //查询所有关键词，结果按时间降序排列
    public List<KeyWord> findAllKeyWord();
    //根据关键词名称查询关键词
    public KeyWord queryKeyWord(KeyWord key);
    //添加关键词
    public int addKeyWord(KeyWord key);
    //删除关键词
    public int deleteKeyWord(KeyWord key);
}
