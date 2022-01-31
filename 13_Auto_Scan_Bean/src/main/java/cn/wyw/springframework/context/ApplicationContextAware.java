package cn.wyw.springframework.context;

import cn.wyw.springframework.beans.BeansException;
import cn.wyw.springframework.beans.factory.Aware;

/**
 * 应用上下文 感知
 * @author 1z
 */
public interface ApplicationContextAware extends Aware {

    /**
     *
     * @param applicationContext
     * @throws BeansException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
