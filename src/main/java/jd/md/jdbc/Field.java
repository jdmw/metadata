package jd.md.jdbc;

import lombok.Data;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by huangxia on 2019/8/28.
 */
@Data
public class Field<T> {
    private String name ;
    private Class<T> javaDataType ;

    public Field(String name, Class<T> javaDataType) {
        this.name = name;
        this.javaDataType = javaDataType;
    }

    public T getValue(ResultSet set ) throws SQLException {
        if(javaDataType.isEnum()){
            if(javaDataType.isInstance(FieldValueOption.class)){
                //return FieldValueContext.parse()
            }
            return set.getObject(name,javaDataType);
        }else{
            return set.getObject(name,javaDataType);
        }
    }
}
