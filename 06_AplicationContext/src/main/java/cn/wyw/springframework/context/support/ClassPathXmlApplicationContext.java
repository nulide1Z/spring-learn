package cn.wyw.springframework.context.support;

import cn.wyw.springframework.beans.BeansException;

public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    public ClassPathXmlApplicationContext(String[] configLocations) {
        this.configLocations = configLocations;
        refresh();
    }

    public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
        this(new String[]{configLocations});
    }


    public void setConfigLocations(String[] configLocations) {
        this.configLocations = configLocations;
    }


    @Override
    protected String[] getConfigLocations() {
        return configLocations;
    }
}
