package cn.wyw.springframework.context;

import cn.wyw.springframework.beans.BeansException;

/**
 * 可配置的应用程序上下文
 *
 * @author wangyuwen
 * @version 1.0, 2021/12/2 14:45
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     * @throws BeansException 定义的bean异常
     **/
    void refresh() throws BeansException;;

    /**
     *  注册销毁钩子
     */
    void registerShutdownHook();

    /**
     * 关闭
     */
    void close();
}
