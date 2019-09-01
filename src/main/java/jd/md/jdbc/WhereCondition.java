package jd.md.jdbc;

import jd.md.db.DBTableField;

public class WhereCondition<V> {

    private DBTableField<V> field;
    public enum Sign {
        EQ,NEQ,GT,LT,GE,LE,ISNULL,NOTNULL,BETWEEN,IN,EXIST,NOT_EXIST
    }
    private Sign sign ;
    private V[] value ;

    public WhereCondition(DBTableField<V> field, Sign sign, V ... value) {
        this.field = field;
        this.sign = sign;
        this.value = value;
    }
}
