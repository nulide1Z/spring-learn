package cn.wyw.springfreamework.factory;

/**
 * bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/8/30 21:56
 */
public interface BeanFactory {

    /**
     * 定义获取bean方法
     *
     * @param name 名称
     * @return  bean
     * @author wangyuwen
     * @date 2021/9/6 - 10:42
     **/
    Object getBean(String name);

}
