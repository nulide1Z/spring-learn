package cn.wyw.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.wyw.springframework.beans.factory.config.BeanDefinition;
import cn.wyw.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 类路径扫描候选组件提供者
 *
 * @author 1z
 * @date 2022/1/30 22:02
 */
public class ClassPathScanningCandidateComponentProvider {

    /**
     * 扫描包路径下的bean定义
     * @param basePackage 包路径
     * @return beanDefinition 集合
     */
    public Set<BeanDefinition> findCandidateComponent(String basePackage){
        LinkedHashSet<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}
