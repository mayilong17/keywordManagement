package com.cs.test;

import com.cs.dao.impl.KeyWordDaoImpl;
import com.cs.entity.KeyWord;
import com.cs.service.KeyWordService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestKeyword {
    @Test
    public void findall(){
        List<KeyWord> list = new KeyWordDaoImpl().findAllKeyWord();
        for (KeyWord k:list) {
            System.out.println(k.toString());
        }
    }
    @Test
    public void add(){
        KeyWord keyWord = new KeyWord(1,"打羽毛球","体育",new Date());
        int i = new KeyWordDaoImpl().addKeyWord(keyWord);
        System.out.println(i);
    }
    @Test
    public void query(){
        KeyWord keyWord1 = new KeyWord();
        keyWord1.setName("读书");
        KeyWord keyWord = new KeyWordDaoImpl().queryKeyWord(keyWord1);
        System.out.println(keyWord);

    }
    @Test
    public void delete(){
        KeyWord keyWord = new KeyWord();
        keyWord.setId(4);
        int i = new KeyWordDaoImpl().deleteKeyWord(keyWord);
        System.out.println(i);
    }
    @Test
    public void query1(){
        KeyWord keyWord = new KeyWordService().queryService("读书");
        System.out.println(keyWord.toString());
    }
}
