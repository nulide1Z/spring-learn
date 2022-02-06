package cn.wyw.springframework.core.io;

import cn.wyw.springframework.util.ClassUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
        this.classLoader = classLoader != null ? classLoader : ClassUtil.getDefaultClassLoader();
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
