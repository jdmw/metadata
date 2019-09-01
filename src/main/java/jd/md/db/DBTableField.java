package jd.md.db;

import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerImpl;
import jd.md.jdbc.WhereCondition;
import jd.util.lang.reflect.EnumUtil;
import lombok.Data;
import org.apache.commons.lang3.EnumUtils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


@Data
public class DBTableField<T> {
    private final String name ;
    private final Class<T> javaDataType ;
    private final boolean isPrimaryKey ;

    private Map<?, T> optionMap = new HashMap<>();

    public DBTableField(String name, Class<T> javaDataType) {
        this(name,javaDataType ,false);
    }

    public DBTableField(String name, Class<T> javaDataType,boolean isPrimaryKey) {
        this.name = name;
        this.javaDataType = javaDataType;
        this.isPrimaryKey = isPrimaryKey;
    }

    private synchronized Map<?, T> getOptionMap(){
        if( optionMap != null){
            optionMap = (Map<?, T>) EnumUtil.getOrdinalEnumMap((Class)javaDataType);
        }
        return optionMap;
    }

    public <V> T getValue(ResultSet set ) throws SQLException {

        if(javaDataType.isEnum()){
            if(javaDataType.isInstance(DBTableFieldValueOption.class)){
                Class<DBTableFieldValueOption<V>> optionClass = (Class<DBTableFieldValueOption<V>>)javaDataType;
                Class<V> valueType = DBTableDBValueContext.getValueType(optionClass);
                V value = getObject(set,name,valueType);
                return (T) DBTableDBValueContext.parse(value,optionClass);
            }else{
                int ordinal = set.getInt(name);
                return getOptionMap().get(ordinal);
            }
        }else{
            return getObject(set,name,javaDataType);
        }
    }

    public WhereCondition<T> eq(T value){
        return new WhereCondition<T>(this, WhereCondition.Sign.EQ,value);
    }
    interface ResultGetter<R> {
        public R get(ResultSet rs,String name ) throws SQLException;
    }
    static Map<Class<?>, ResultGetter> SETTERS = new HashMap<>();
    static {
        SETTERS.put(boolean.class,(rs,name)->rs.getBoolean(name));
        SETTERS.put(Boolean.class,(rs,name)->rs.getBoolean(name));

        SETTERS.put(byte.class,(rs,name)->rs.getByte(name));
        SETTERS.put(int.class,(rs,name)->rs.getInt(name));
        SETTERS.put(short.class,(rs,name)->rs.getShort(name));
        SETTERS.put(long.class,(rs,name)->rs.getLong(name));
        SETTERS.put(double.class,(rs,name)->rs.getDouble(name));
        SETTERS.put(float.class,(rs,name)->rs.getFloat(name));
        SETTERS.put(int.class,(rs,name)->rs.getInt(name));
        SETTERS.put(Byte.class,(rs,name)->rs.getInt(name));
        SETTERS.put(Integer.class,(rs,name)->rs.getInt(name));
        SETTERS.put(Short.class,(rs,name)->rs.getShort(name));
        SETTERS.put(Long.class,(rs,name)->rs.getLong(name));
        SETTERS.put(Double.class,(rs,name)->rs.getDouble(name));
        SETTERS.put(Float.class,(rs,name)->rs.getFloat(name));

        SETTERS.put(String.class,(rs,name)->rs.getString(name));
        SETTERS.put(Byte[].class,(rs,name)->rs.getBytes(name));

        SETTERS.put(java.sql.Date.class,(rs,name)->rs.getDate(name));
        SETTERS.put(java.util.Date.class,(rs,name)->rs.getDate(name));
        SETTERS.put(java.sql.Time.class,(rs,name)->rs.getTime(name));
        SETTERS.put(java.sql.Timestamp.class,(rs,name)->rs.getTimestamp(name));
    }
    private static <T> T getObject(ResultSet rs,String name ,Class<T> type) throws SQLException {
        Object o = SETTERS.get(type).get(rs, name);
        return (T)o;
    }
}
