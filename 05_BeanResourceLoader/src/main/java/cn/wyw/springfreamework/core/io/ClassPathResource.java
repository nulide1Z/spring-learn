package cn.wyw.springfreamework.core.io;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.misc.ClassLoaderUtil;

/**
 * 类路径资源
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 10:31
 */
public class ClassPathResource implements Resource{

    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        // todo 换成classUtil.getDefaultClass();
        this.classLoader = classLoader != null ? classLoader : null;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = this.classLoader.getResourceAsStream(path);
        if (resourceAsStream == null){
            throw new FileNotFoundException(this.path + "cant be  opened because it doesnt exist");
        }
        return resourceAsStream;
    }
}
