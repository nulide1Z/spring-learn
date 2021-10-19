package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.beans.BeansException;
import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;

/**
 * 实例化策略
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 17:19
 */
public interface InstantiationStrategy {

   /**
    *  实例化
    *
    * @param beanDefinition bean 定义
    * @param beanName bean名称
    * @param constructor 构造器
    * @param args 参数
    * @return object
    * @author wangyuwen
    * @date 2021/9/29 - 17:02
    **/
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;

}
