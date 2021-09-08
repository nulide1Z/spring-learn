package cn.wyw.springfreamework.factory;

/**
 * 基础异常
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 00:37
 */
public class BeanException extends RuntimeException{

    public BeanException(String msg){
        super(msg);
    }

    public BeanException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
