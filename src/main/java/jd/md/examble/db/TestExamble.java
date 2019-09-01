package jd.md.examble.db;

import ch.qos.logback.core.db.DBHelper;
import jd.md.db.DBTableDBValueContext;
import jd.md.examble.db.cst.Sex;
import jd.md.examble.db.dao.UserDao;
import jd.md.examble.db.entity.UserDO;
import static jd.util.db.JdbcProperty.DbType.MYSQL;

import jd.util.db.JdbcProperty;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by huangxia on 2019/8/29.
 */
public class TestExamble {

    public static void main(String[] arg){
        //System.out.println(Enum.valueOf(Sex.class,Sex.Female.name()));
        //System.out.println(Arrays.toString(sex.getClass().getMethods()));
        //FieldValueOptions.addEnum(Sex.values());
        Sex sex = DBTableDBValueContext.parse(Sex.Male.getValue(),Sex.class);
        System.out.println(sex);
        JdbcTemplate jt = new JdbcTemplate(new JdbcProperty(MYSQL,"localhost","demo","user","pass").buildDS());
        UserDao dao = new UserDao(jt);
        UserDO user = dao.getById(1);
        System.out.println(user);
    }


}
