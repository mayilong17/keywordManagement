package com.cs.service;

import com.cs.dao.impl.KeyWordDaoImpl;
import com.cs.entity.KeyWord;

import java.util.List;

public class KeyWordService {
    private KeyWordDaoImpl key=new KeyWordDaoImpl();
    //查询所有关键词，结果按时间降序排列
    public List<KeyWord> findAllService(){
        return key.findAllKeyWord();
    }
    //根据关键词名称查询关键词
    public KeyWord queryService(String name){
        KeyWord keyWord = new KeyWord();
        keyWord.setName(name);
        return key.queryKeyWord(keyWord);
    }
    //添加关键词
    public boolean addService(KeyWord keyWord){
        int i = key.addKeyWord(keyWord);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }
    //删除关键词
    public boolean deleteService(int id){
        KeyWord keyWord = new KeyWord();
        keyWord.setId(id);
        int i = key.deleteKeyWord(keyWord);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }
}
