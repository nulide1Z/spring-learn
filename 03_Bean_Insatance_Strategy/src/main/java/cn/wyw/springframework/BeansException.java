package cn.wyw.springframework;

/**
 * bean 异常定义
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:27
 */
public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
