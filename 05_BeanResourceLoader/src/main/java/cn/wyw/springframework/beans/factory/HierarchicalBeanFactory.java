package cn.wyw.springframework.beans.factory;

/**
 * 由 bean 工厂实现的子接口，可以是层次结构的一部分。
 * 可以在 ConfigurableBeanFactory 接口中找到允许以可配置方式设置父级的 bean 工厂的相应setParentBeanFactory方法。
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/21 16:19
 */
public interface HierarchicalBeanFactory  extends BeanFactory{

}
