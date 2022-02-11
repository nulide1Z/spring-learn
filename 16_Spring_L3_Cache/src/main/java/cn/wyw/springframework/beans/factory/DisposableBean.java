package cn.wyw.springframework.beans.factory;

public interface DisposableBean {

    /**
     * 在销毁 bean 时由包含BeanFactory调用。
     * @throws Exception 异常
     */
    void destroy() throws Exception;
}
