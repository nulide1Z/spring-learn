package cn.wyw.springframework.context.support;

import cn.wyw.springframework.beans.BeansException;

/**
 * Xml 形式的类路径应用程序上下文 , 用于提供给用户做bean的自定义操作的类
 *
 * @author wangyuwen
 * @date 2021/12/7 - 11:48
 **/
public class ClassPathXmlApplicationContext  extends AbstractXmlApplicationContext {

    /**
     * 当前xml 应用上下文对应的配置的类路径
     */
    private final String[] configLocations;

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        // 加载bean 类路径下的bean
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }

    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
