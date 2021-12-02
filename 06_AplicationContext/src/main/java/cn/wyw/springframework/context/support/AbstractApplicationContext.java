package cn.wyw.springframework.context.support;

import cn.wyw.springframework.context.ConfigurableApplicationContext;
import cn.wyw.springframework.core.io.DefaultResourceLoader;

/**
 * 抽象应用上下文
 *
 * @author wangyuwen
 * @version 1.0, 2021/12/2 14:42
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {


    @Override
    public void refresh() {

    }

    protected void refreshBeanFactory() {

    }
}
