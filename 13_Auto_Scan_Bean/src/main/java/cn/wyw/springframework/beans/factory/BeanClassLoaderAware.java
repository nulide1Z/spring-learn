package cn.wyw.springframework.beans.factory;

import cn.wyw.springframework.beans.BeansException;

/**
 *  bean 类加载器 感知
 * @author 1z
 */
public interface BeanClassLoaderAware extends Aware {

    /**
     *  设置bean 类加载器
     * @param classLoader 类加载器
     * @throws BeansException bean 异常
     */
    void setBeanClassLoader(ClassLoader classLoader) throws BeansException;
}
