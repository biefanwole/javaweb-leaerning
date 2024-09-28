package com.example.bookonline.dao.impl;

import com.example.bookonline.dao.UserDao;
import com.example.bookonline.entity.User;
import com.example.bookonline.util.JdbcUtil;
import com.example.bookonline.util.Md5Util;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate=new JdbcTemplate(JdbcUtil.getDataSource());
    @Override
    public int insertUser(User user){
        String sql ="INSERT INTO t_user(account,password,nickname,avatar,address) VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql,user.getAccount(),
                Md5Util.crypt(user.getPassword()),
                user.getNickname(),user.getAvatar(),user.getAddress());
    }

    @Override
    public User findUser(User userDto){
        try {
            String sql="SELECT * FROM t_user WHERE account=? AND password=?";
            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>
                    (User.class),userDto.getAccount(),Md5Util.crypt(userDto.getPassword()));
        }catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
