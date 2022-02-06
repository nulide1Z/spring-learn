package cn.wyw.springframework.core.io;

/**
 * 资源加载器
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 13:45
 */
public interface ResourceLoader {

    String ClassPATH_URL_prefix = "classpath:";

    /**
     * 根据路径获取资源文件
     *   先判断是同一包下的资源文件
     *   再判断是否url
     *   之后才是当前服务器的文件
     *
     * @param location 路径
     * @return  资源
     * @author wangyuwen
     * @date 2021/11/25 - 15:54
     **/
    Resource getResource(String location);

}
