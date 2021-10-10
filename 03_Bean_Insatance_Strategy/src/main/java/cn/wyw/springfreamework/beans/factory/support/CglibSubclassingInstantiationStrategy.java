package cn.wyw.springfreamework.beans.factory.support;

import cn.wyw.springfreamework.BeansException;
import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import java.lang.reflect.Constructor;
import java.util.Objects;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * cglib子类实例化策略实现类
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/6 17:52
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args)
        throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });
        if ( null == constructor) {
            return enhancer.create();
        }
        return enhancer.create(constructor.getParameterTypes(), args);
    }
}
