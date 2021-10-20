package cn.wyw.springfreamework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源接口
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 10:27
 */
public interface Resource {

    /**
     * 获取输入流
     *
     * @return  inputStream 流
     * @author wangyuwen
     * @date 2021/10/20 - 10:28
     **/
    InputStream getInputStream() throws IOException;

}
