package cn.wyw.springfreamework.beans.factory.config;

/**
 * 单例bean 注册接口定义
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:37
 */
public interface SingletonBeanRegister {

    Object getSingleton(String beanName);

}
