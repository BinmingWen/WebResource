package cn.wyu.db;

public class DataAccessException extends RuntimeException{
    public DataAccessException(String message){
        super(message);
    }
    public DataAccessException(String message,Throwable ex){
        super(message,ex);
    }
}
