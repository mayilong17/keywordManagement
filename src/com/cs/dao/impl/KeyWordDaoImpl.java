package com.cs.dao.impl;

import com.cs.basedao.baseDao;
import com.cs.dao.KeyWordDao;
import com.cs.entity.KeyWord;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class KeyWordDaoImpl implements KeyWordDao {
    private JdbcTemplate template= baseDao.getTemplate();
    @Override
    public List<KeyWord> findAllKeyWord() {
        String sql="select * from keyword order by createDate DESC ";
        return template.query(sql,new BeanPropertyRowMapper<>(KeyWord.class));
    }

    @Override
    public KeyWord queryKeyWord(KeyWord key) {
        String sql="select * from keyword where name=?";
        Object[] obj={key.getName()};
        List<KeyWord> query = template.query(sql,new BeanPropertyRowMapper<>(KeyWord.class),obj);
        if (query.isEmpty()){
            return null;
        }else{
            return query.get(0);
        }
    }

    @Override
    public int addKeyWord(KeyWord key) {
        String sql="insert into keyword values(null,?,?,?)";
        Object[] obj={key.getName(),key.getType(),key.getCreateDate()};
        return template.update(sql, obj);
    }

    @Override
    public int deleteKeyWord(KeyWord key) {
        String sql="delete from keyword  where id=?";
        Object[] obj={key.getId()};
        return template.update(sql,obj);
    }
}
