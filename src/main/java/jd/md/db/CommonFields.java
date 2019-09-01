package jd.md.db;

public class CommonFields {

    public static class IntField extends DBTableField<Integer>{
        public IntField(String name) {
            super(name,int.class ,false);
        }
        public IntField(String name, boolean isPrimaryKey) {
            super(name,int.class ,isPrimaryKey);
        }
    }
    public static class StringField extends DBTableField<String>{
        public StringField(String name) {
            super(name,String.class ,false);
        }
        public StringField(String name, boolean isPrimaryKey) {
            super(name,String.class ,isPrimaryKey);
        }
    }

    public static class UniqueKey<T> extends DBTableField<T>{
        public UniqueKey(String name, Class<T> javaDataType) {
            super(name,javaDataType ,false);
        }
        public UniqueKey(String name, Class<T> javaDataType,boolean isPrimaryKey) {
            super(name,javaDataType ,isPrimaryKey);
        }
    }
    public static class PrimaryKey<T> extends UniqueKey<T>{
        public PrimaryKey(String name, Class<T> javaDataType) {
            super(name,javaDataType ,false);
        }
    }
    public static class EnableField<T> extends DBTableField<T>{
        private T enableValue ;
        public EnableField(String name,Class<T> javaDataType,T enableValue){
            super(name,javaDataType,false);
            this.enableValue = enableValue;
        }
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
