package cn.wyw.springframework.beans.factory;

import cn.wyw.springframework.beans.BeansException;

/**
 * @author 1z
 * @date 2022/2/11 21:46
 */
public interface ObjectFactory<T> {

    /**
     * 获取对象
     * @return 对象
     * @throws BeansException bean 异常
     */
    T getObject() throws BeansException;
}
