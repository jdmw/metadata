package jd.md.jdbc;

import jd.md.examble.db.cst.Sex;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangxia on 2019/8/29.
 */
public class FieldValueContext {

    private static final Map<Class<? extends Enum>,Map<Object,FieldValueOption>> enumMap = new HashMap<>();
    private static synchronized <V,T extends FieldValueOption<V>> Map<Object, FieldValueOption> register(T[] values){
        if( values == null || values.length == 0) throw new IllegalArgumentException("values can't be empty");
        Map<Object ,FieldValueOption> valueMap = new HashMap<>();
        for(T option : values){
            valueMap.put(((FieldValueOption)option).getValue(),(FieldValueOption)option);
        }
        enumMap.put((Class<? extends Enum>) values[0].getClass(),valueMap);
        return valueMap;
    }

    public static <V,T extends FieldValueOption<V>> T parse(V value,Class<T> optionClass){
        Map<Object,FieldValueOption> valueMap = enumMap.get(optionClass);
        if(valueMap == null){
            try {
                valueMap = register((T[]) optionClass.getMethod("values").invoke(null));
            } catch (IllegalAccessException |InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return (T) valueMap.get(value) ;
    }


    public static void main(String[] arg){
        Sex sex = FieldValueContext.parse(Sex.Male.getValue(),Sex.class);
        System.out.println(sex);
    }
}
