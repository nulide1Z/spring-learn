package cn.wyw.springfreamework;

/**
 * a service
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/29 18:26
 */
public class AService {

    private String name;

    public AService(String name) {
        this.name = name;
    }

    public void test(){
        System.out.println(this.name);
    }

    @Override
    public String toString() {
        return "AService{" +
            "name='" + name + '\'' +
            '}';
    }
}
