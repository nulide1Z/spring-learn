package cn.wyw.springfreamework.factory;

/**
 * bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 21:56
 */
public interface BeanFactory {

    /**
     * 获取bean
     **/
    Object getBean(String name);

}
