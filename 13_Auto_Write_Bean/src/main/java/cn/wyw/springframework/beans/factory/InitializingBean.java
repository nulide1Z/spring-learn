package cn.wyw.springframework.beans.factory;

/**
 * 初始化bean
 * @author 1z
 */
public interface InitializingBean {

     /**
      * 属性设置后置方法
      */
     void afterPropertiesSet() throws Exception;
}
