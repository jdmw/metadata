package jd.md.db;

import jd.md.examble.db.cst.Sex;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by huangxia on 2019/8/29.
 */
public class DBTableDBValueContext {

    private static final Map<Class<? extends Enum>,Map<Object,DBTableFieldValueOption>> enumMap = new ConcurrentHashMap<>();
    private static Map<Class<DBTableFieldValueOption<?>>,Class<?>> enumValueMap = new ConcurrentHashMap<>();
    private static <V,T extends DBTableFieldValueOption<V>> Map<Object, DBTableFieldValueOption> register(T[] values){
        if( values == null || values.length == 0) throw new IllegalArgumentException("values can't be empty");
        Map<Object ,DBTableFieldValueOption> valueMap = new HashMap<>();
        for(T option : values){
            valueMap.put(((DBTableFieldValueOption)option).getValue(),(DBTableFieldValueOption)option);
        }
        enumMap.put((Class<? extends Enum>) values[0].getClass(),valueMap);
        return valueMap;
    }

    public static <V,T extends DBTableFieldValueOption<V>> Map<Object,DBTableFieldValueOption> getOptionMap(Class<T> optionClass){
        Map<Object,DBTableFieldValueOption> valueMap = enumMap.get(optionClass);
        if(valueMap == null){
            try {
                valueMap = register((T[]) optionClass.getMethod("values").invoke(null));
            } catch (IllegalAccessException |InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return valueMap;
    }

    public static <V,T extends DBTableFieldValueOption<V>> T parse(V value,Class<T> optionClass){
        Map<Object,DBTableFieldValueOption> valueMap = getOptionMap(optionClass);
        return (T) valueMap.get(value) ;
    }

    public  static <V> Class<V> getValueType(Class<DBTableFieldValueOption<V>> valueOptionClass){
        Class<V> type = (Class<V>) enumValueMap.get(valueOptionClass);
        if( type == null){
            try {
                type = (Class<V>) valueOptionClass.getMethod("getValue").getReturnType();
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return type ;
    }

    public static void main(String[] arg){
        Sex sex = DBTableDBValueContext.parse(Sex.Male.getValue(),Sex.class);
        System.out.println(sex);
    }
}
