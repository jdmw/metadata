package jd.md.examble.db;

import jd.md.db.DBSchema;
import jd.md.db.DBTable;
import jd.md.examble.db.cst.Sex;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huangxia on 2019/8/28.
 */
@Data
public class SchemaDemo implements DBSchema {

    private final String schemaName = "" ;
    private final List<DBTable> tables = Arrays.asList();

    public static final DBSchema DEMO = new SchemaDemo();

}
