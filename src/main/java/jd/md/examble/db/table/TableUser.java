package jd.md.examble.db.table;


import jd.md.db.CommonFields;
import jd.md.db.DBSchema;
import jd.md.db.DBTable;
import jd.md.db.DBTableField;
import jd.md.examble.db.SchemaDemo;
import jd.md.examble.db.cst.Sex;

import java.sql.Timestamp;

public class TableUser extends DBTable {

    public final static DBTableField<Integer> ID = new DBTableField("ID",Integer.class);
    public final static DBTableField<String> CODE = new DBTableField("CODE",String.class);
    public final static DBTableField<String> NAME = new DBTableField("NAME",String.class);
    public final static DBTableField<Integer> AGE = new DBTableField("AGE",int.class);
    public final static DBTableField<Sex> SEX = new DBTableField("SEX",Sex.class);
    public final static DBTableField<Boolean> STATUS = new CommonFields.EnableField<>("STATUS",Boolean.class,true);
    public final static DBTableField<Timestamp> GMT_CREATE = new DBTableField<>("GMT_CREATE", Timestamp.class);
    public final static DBTableField<Timestamp> GMT_MODIFIED = new DBTableField<>("GMT_MODIFIED",Timestamp.class);

    public TableUser(){
        super(SchemaDemo.DEMO,"user",new DBTableField[]{
                ID,CODE,NAME,AGE,SEX,STATUS,GMT_CREATE,GMT_MODIFIED
        });
    }

    public final static DBTable TABLE = new TableUser();
}
