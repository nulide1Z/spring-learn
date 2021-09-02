package cn.wyw.springfreamework.factory.config;

/**
 * 单例bean 注册接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 23:09
 */
public interface SingletonBeanRegister {

    /**
     * 获取单例bean
     **/
    Object getSingleton(String beanName);

}