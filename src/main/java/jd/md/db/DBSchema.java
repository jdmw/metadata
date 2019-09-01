package jd.md.db;

import java.util.List;

public interface DBSchema {

    String getSchemaName();

    List<DBTable> getTables();

}
