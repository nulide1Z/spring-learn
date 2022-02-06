package cn.wyw.springframework.util;

/**
 * 字符串值解析器
 * @author 1z
 * @date 2022/1/31 18:25
 */
public interface StringValueResolver {

    /**
     * 解析字符串
     * @param strVal 字符串值
     * @return 字符串
     */
    String  resolveStringValue(String strVal);
}
