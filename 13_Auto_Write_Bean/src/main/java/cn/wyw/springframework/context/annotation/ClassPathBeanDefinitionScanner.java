package cn.wyw.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.beans.factory.support.BeanDefinitionRegister;
import cn.wyw.springframework.stereotype.Component;

import java.util.Set;

/**
 * 类路径 Bean 定义扫描器
 *
 * @author 1z
 * @date 2022/1/30 22:01
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {

    private BeanDefinitionRegister register;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegister beanDefinitionRegister) {
        this.register = beanDefinitionRegister;
    }

    /**
     *  扫描包路径下的beanDefinition
     * @param basePackages
     */
    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidateComponent = findCandidateComponent(basePackage);
            for (BeanDefinition beanDefinition : candidateComponent) {
                String beanScope = this.resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)){
                    beanDefinition.setScope(beanScope);
                }
                register.registerBeanDefinition(this.determineBeanName(beanDefinition), beanDefinition);
            }
        }
    }

    /**
     * 发挥 beanScope
     * @param beanDefinition bean定义
     * @return bean的scope
     */
    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Scope scope = beanClass.getAnnotation(Scope.class);
        if (scope != null){
            return scope.value();
        }
        return StrUtil.EMPTY;
    }

    /**
     * 确定bean 名称
     * @param beanDefinition bean定义
     * @return bean名称
     */
    private String determineBeanName(BeanDefinition beanDefinition) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Component component = beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isEmpty(value)){
            value =  StrUtil.lowerFirst(beanClass.getSimpleName());
        }
        return value;
    }

}
