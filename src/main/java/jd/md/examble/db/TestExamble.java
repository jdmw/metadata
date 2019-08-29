package jd.md.examble.db;

import jd.md.examble.db.cst.Sex;
import jd.md.jdbc.FieldValueContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * Created by huangxia on 2019/8/29.
 */
public class TestExamble {

    public static void main(String[] arg){
        //System.out.println(Enum.valueOf(Sex.class,Sex.Female.name()));
        //System.out.println(Arrays.toString(sex.getClass().getMethods()));
        //FieldValueOptions.addEnum(Sex.values());
        Sex sex = FieldValueContext.parse(Sex.Male.getValue(),Sex.class);
        System.out.println(sex);
    }
}
