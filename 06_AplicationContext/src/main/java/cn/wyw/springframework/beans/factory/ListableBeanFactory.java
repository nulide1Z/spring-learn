package cn.wyw.springframework.beans.factory;

import cn.wyw.springframework.beans.BeansException;
import java.util.Map;

/**
 * 扩展bean 工厂的接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/21 16:22
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 根据类型获取bean 的map
     *
     * @param type 类型
     * @return  bean map
     * @author wangyuwen
     * @date 2021/10/21 - 16:25
     * @throws BeansException 异常
     **/
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * 获取bean工厂里所有定义的名称
     *
     * @return  名称数组
     * @author wangyuwen
     * @date 2021/10/21 - 16:29
     **/
    String[] getBeanDefinitionNames();

}
