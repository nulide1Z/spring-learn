package cn.wyw.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 默认资源加载实现类
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 14:42
 */
public class DefaultResourceLoader implements ResourceLoader{

    @Override
    public Resource getResource(String location) {
        if (null == location){
            throw new IllegalArgumentException("location cant be null");
        }
        if (location.startsWith(ClassPATH_URL_prefix)){
            return new ClassPathResource(location.substring(ClassPATH_URL_prefix.length()));
        }
        else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
