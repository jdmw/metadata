package jd.md.examble.db.entity;

import jd.md.db.DBTable;
import jd.md.db.TableEntity;
import jd.md.examble.db.cst.Sex;
import jd.md.examble.db.table.TableUser;
import lombok.Data;
import lombok.val;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDO extends TableEntity {

    private int id ;
    private String code ;
    private String name ;
    private int age ;
    private Sex sex ;
    private boolean status ;
    private Timestamp gmtCreate ;
    private Timestamp gmtModified ;

}
