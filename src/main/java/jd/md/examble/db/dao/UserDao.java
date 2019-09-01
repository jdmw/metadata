package jd.md.examble.db.dao;

import jd.md.examble.db.entity.UserDO;
import static jd.md.examble.db.table.TableUser.*;

import jd.md.examble.db.table.TableUser;
import jd.md.jdbc.BaseDao;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by huangxia on 2019/8/29.
 */
@Component
public class UserDao extends BaseDao<UserDO> {


    public UserDao(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, TABLE,UserDO.class);
    }

/*    public UserDO getById(int id){
        String sql = "select * from user where id = ? " ;
        return jdbcTemplate.queryForObject(sql,new Object[]{id},(rs,num)->{
            UserDO userDO = new UserDO();
            setValue(userDO,rs);
            return userDO;
        }) ;
    }*/
}
