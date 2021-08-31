package cn.wyw.springfreamework.factory;

/**
 * 基础异常
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 00:37
 */
public class BaseException extends RuntimeException{

    private String msg;

    private Exception exception;


     public BaseException(String msg, Exception e){
        this.msg = msg;
        this.exception = e;
    }

    public BaseException(String msg){
        this.msg = msg;
    }
}
