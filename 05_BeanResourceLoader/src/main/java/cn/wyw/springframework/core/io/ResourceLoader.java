package cn.wyw.springframework.core.io;

/**
 * 资源加载接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 13:45
 */
public interface ResourceLoader {

    String ClassPATH_URL_prefix = "classpath:";

    Resource getResource(String location);

}
