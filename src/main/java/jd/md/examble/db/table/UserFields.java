package jd.md.examble.db.table;


import jd.md.examble.db.cst.Sex;
import jd.md.jdbc.Field;

public class UserFields {

    public static Field<Integer> ID = new Field("ID",Integer.class);
    public static Field<String> NAME = new Field("NAME",String.class);
    public static Field<Integer> AGE = new Field("AGE",int.class);
    public static Field<Sex> SEX = new Field("SEX",Sex.class);
}
