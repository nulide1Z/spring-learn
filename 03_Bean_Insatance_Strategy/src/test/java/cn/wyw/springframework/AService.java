package cn.wyw.springframework;

/**
 * a service
 *
 * @author wangyuwen
 * @version 1.0, 2021/9/29 18:26
 */
public class AService {

    private String name;

/*    private Integer sex;

    private Integer num;*/

    public AService(String name) {
        this.name = name;
    }
/*  // 不同参数类型的构造会有问题
    public AService(String name, Integer sex) {
        this.name = name;
        this.sex = sex;
    }

    public AService(Integer sex, Integer num) {
        this.sex = sex;
        this.num = num;
    }*/

    public AService() {
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
