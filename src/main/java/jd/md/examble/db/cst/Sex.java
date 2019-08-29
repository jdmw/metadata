package jd.md.examble.db.cst;

import jd.md.jdbc.FieldValueOption;

public enum Sex implements FieldValueOption<Byte>{
    Male("Male",(byte)1),Female("Female",(byte)2) ;

    private String name ;
    private byte value ;

    Sex(String name, byte value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Byte getValue() {
        return value;
    }

}
