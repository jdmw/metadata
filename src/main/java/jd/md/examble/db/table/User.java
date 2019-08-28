package jd.md.examble.db.table;


import jd.md.jdbc.Field;
import sun.management.Agent;

/**
 * Created by huangxia on 2019/8/28.
 */
public class User {

    public static Field<Integer> ID = new Field("ID",Integer.class);
    public static Field<String> NAME = new Field("NAME",String.class);
    public static Field AGE = new Field("AGE",int.class);
}
