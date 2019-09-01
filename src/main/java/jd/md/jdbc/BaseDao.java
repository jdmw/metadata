package jd.md.jdbc;

import jd.md.db.DBTable;
import jd.md.db.DBTableField;
import jd.md.db.TableEntity;
import jd.md.examble.db.entity.UserDO;
import jd.util.lang.reflect.ReflectUt;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class BaseDao<D extends TableEntity> {

    private JdbcTemplate jdbcTemplate;
    private Class<D> entityClass ;
    private final DBTable table ;
    private final Map<String, DBTableField> nameDBFields  ;
    private final Map<String, Field> nameJavaFields ;

    public BaseDao(JdbcTemplate jdbcTemplate,DBTable table, Class<D> entityClass) {
        this.jdbcTemplate = jdbcTemplate;
        this.table = table;
        this.entityClass = entityClass ;
        this.nameDBFields = table.getFields().stream().collect(Collectors.toMap(f ->toCleanName( f.getName()), f -> f));
        this.nameJavaFields = getNameJavaFields(entityClass);
    }

    private static String toCleanName(String name){
        return name.toUpperCase().replaceAll("_","");
    }

    private Map<String, Field> getNameJavaFields( Class<D> entityClass){
        Map<String, Field> nameJavaFields = new HashMap<>();
        for(Field field : entityClass.getDeclaredFields()){
            String fieldName = toCleanName(field.getName());
            if(nameDBFields.containsKey(fieldName)){
                nameJavaFields.put(fieldName,field);
            }
        }
        return nameJavaFields;
    }

    public void setValue(TableEntity entity,ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        for( int i=1;i<=metaData.getColumnCount();i++){
            String name = toCleanName(metaData.getColumnName(i));
            DBTableField field = nameDBFields.get(name);
            Field javaFields = nameJavaFields.get(name);
            if( field != null && javaFields != null){
                javaFields.setAccessible(true);
                ReflectUt.setField(entity,javaFields,field.getValue(rs));
            }
        }
    }

    public D newDO(){
        try {
            return entityClass.newInstance();
        } catch (InstantiationException|IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private RowMapper<D> rowMapper = (rs,num)->{
        D entity = newDO();
        setValue(entity,rs);
        return entity;
    };

    public D getById(int id){
        String sql = "select * from user where id = ? " ;
        return jdbcTemplate.queryForObject(sql,new Object[]{id},rowMapper) ;
    }

    public void select(DBTableField[] fields){

    }
}
