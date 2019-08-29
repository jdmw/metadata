package jd.md.examble.db.dao;

import jd.demo.springboot.mybatis.user.entity.User;
import jd.md.examble.db.entity.UserDO;
import jd.md.examble.db.table.UserFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by huangxia on 2019/8/29.
 */
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDO getById(int id){
        String sql = "select * from user where id = ? " ;
        return jdbcTemplate.queryForObject(sql,new Object[]{id},(rs,num)->{
            UserDO userDO = new UserDO();
            userDO.setId(rs.getInt(UserFields.ID.getName()));
            userDO.setName(rs.getString(UserFields.NAME.getName()));
            userDO.setName(rs.getString(UserFields.NAME.getName()));
            userDO.setAge(rs.getInt(UserFields.AGE.getName()));
            //userDO.setSex(rs.getByte(UserFields.SEX.getName()));
            return userDO;
        }) ;
    }
}
