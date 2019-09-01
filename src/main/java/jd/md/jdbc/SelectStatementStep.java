package jd.md.jdbc;

import jd.md.db.DBTableField;
import jd.md.db.TableEntity;

import java.util.ArrayList;
import java.util.List;

public class SelectStatementStep {

    BaseDao baseDao;
    DBTableField[] fields;
    List<WhereCondition> conditionList = new ArrayList<>();

    public SelectStatementStep(BaseDao baseDao, DBTableField[] fields) {
        this.baseDao = baseDao;
        this.fields = fields;
    }

    public <T> SelectStatementStep where(WhereCondition condition){
        conditionList.add( condition);
        return this ;
    }

    public <T> SelectStatementStep and(WhereCondition condition){
        conditionList.add( condition);
        return this ;
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
