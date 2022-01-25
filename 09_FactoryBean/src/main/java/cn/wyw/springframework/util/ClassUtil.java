package cn.wyw.springframework.util;

/**
 * class util todo 资源加载线程问题
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/21 11:25
 */
public class ClassUtil {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }
        catch (Throwable ex) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl == null) {
            // No thread context class loader -> use class loader of this class.
            cl = ClassUtil.class.getClassLoader();
        }
        return cl;
    }

}
