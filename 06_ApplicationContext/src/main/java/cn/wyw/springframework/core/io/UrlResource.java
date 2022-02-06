package cn.wyw.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL 资源
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 10:54
 */
public class UrlResource implements Resource{


    private final URL url;

    public UrlResource( URL url) {
        if (null == url){
            throw new RuntimeException("url cant be null");
        }
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        try {
            return urlConnection.getInputStream();
        } catch (IOException e) {
            if (urlConnection instanceof HttpURLConnection){
                ((HttpURLConnection) urlConnection).disconnect();
            }
            throw e;
        }
    }
}
