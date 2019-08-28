package jd.md.jdbc;

import lombok.Data;

/**
 * Created by huangxia on 2019/8/28.
 */
@Data
public class Field<T> {
    private String name ;
    private Class<T> JavaDataType ;

    public Field(String name, Class<T> javaDataType) {
        this.name = name;
        JavaDataType = javaDataType;
    }
}
