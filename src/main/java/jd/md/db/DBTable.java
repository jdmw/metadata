package jd.md.db;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class DBTable {

    private final DBSchema schema;
    private final String tableName ;
    private final List<DBTableField> fields;

    protected DBTable(String tableName, DBTableField[] fields) {
        this(null,tableName,fields);
    }

    protected DBTable(DBSchema schema, String tableName, DBTableField[] fields) {
        this.schema = schema;
        this.tableName = tableName;
        this.fields = Arrays.asList(fields);
    }
}
