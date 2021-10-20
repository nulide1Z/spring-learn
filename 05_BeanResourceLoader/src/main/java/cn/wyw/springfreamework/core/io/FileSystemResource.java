package cn.wyw.springfreamework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 系统文件资源
 *
 * @author wangyuwen
 * @version 1.0, 2021/10/20 10:51
 */
public class FileSystemResource implements Resource{

    private final String path;

    private final File file;

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public String getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }
}
