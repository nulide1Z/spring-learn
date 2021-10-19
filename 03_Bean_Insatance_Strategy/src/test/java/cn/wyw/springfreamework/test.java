package cn.wyw.springfreamework;

import cn.wyw.springfreamework.beans.factory.config.BeanDefinition;
import cn.wyw.springfreamework.beans.factory.support.DefaultListableBeanFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

/**
 * 测试方法
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/30 16:00
 */
public class test {

    @Test
    public void testStrategy(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(AService.class);
        defaultListableBeanFactory.registerBeanDefinition("AService", beanDefinition);

        AService bean = (AService) defaultListableBeanFactory.getBean("AService", "罗马哥", 1);
        bean.test();

    }

    @Test
    public void testInitBean() throws InstantiationException, IllegalAccessException {
        AService aService =AService.class.newInstance();
        aService.test();
        System.out.println(aService);

    }

    @Test
    public void test_constructor() throws Exception {
        Class<AService> userServiceClass = AService.class;
        Constructor<AService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        AService userService = declaredConstructor.newInstance("罗马哥");
        System.out.println(userService);
    }

    @Test
    public void testGetParamConstructor() throws Exception{
        Class<AService> aServiceClass = AService.class;
        Constructor<?>[] declaredConstructors = aServiceClass.getDeclaredConstructors();
        Constructor<?> declaredConstructor = declaredConstructors[1];
        Constructor<AService> constructor = aServiceClass.getDeclaredConstructor(declaredConstructor.getParameterTypes());
        AService aService = constructor.newInstance("asdasda");
        System.out.println(aService);
    }

    @Test
    public void testCglibConstructor() throws Exception{
        Enhancer enhancer  = new Enhancer();
        enhancer.setSuperclass(AService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                return null;
            }
        });
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object o = enhancer.create(new Class[]{String.class}, new Object[]{"liusdfhi"});
        System.out.println(o);

    }


}
