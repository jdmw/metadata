package jd.md.examble.db.entity;

import jd.md.examble.db.cst.Sex;
import lombok.Data;

@Data
public class UserDO {

    private int id ;
    private String name ;
    private int age ;
    private Sex sex ;
}
