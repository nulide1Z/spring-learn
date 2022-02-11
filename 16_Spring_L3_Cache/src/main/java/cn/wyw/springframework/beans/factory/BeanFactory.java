package cn.wyw.springframework.beans.factory;

/**
 * bean 工厂
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 15:30
 */
public interface BeanFactory {

    /**
     * 获取bean 接口
     *
     * @param name 名称
     * @return bean
     * @author wangyuwen
     * @date 2021/9/6 - 15:30
     **/
    Object getBean(String name);


    /**
     * 带构造参数获取bean
     *
     * @param name 名称
     * @param args 参数
     * @return bean
     * @author wangyuwen
     * @date 2021/9/6 - 15:31
     **/
    Object getBean(String name, Object...args);

    /**
     * 按名称和类型获取bean
     *
     * @param name bean名称
     * @param requiredType 所需类型
     * @return  bean
     * @author wangyuwen
     * @date 2021/10/21 - 16:16
     **/
    <T> T getBean(String name, Class<T> requiredType);

    /**
     * 根据类型查找bean
     * @param requiredType 类型
     * @param <T> bean
     * @return bean
     */
    <T> T getBean( Class<T> requiredType);

}
