package cn.wyw.springframework.context;

/**
 * 可配置的应用程序上下文
 *
 * @author wangyuwen
 * @version 1.0, 2021/12/2 14:45
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新应用上下文
     **/
    void refresh();

}
