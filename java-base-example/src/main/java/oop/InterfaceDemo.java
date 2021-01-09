package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 接口 方法 成员变量 默认方法 静态方法
 *
 * @Author: Tu-Yi
 * @Date: 2021/1/9 11:41
 *
 */
public interface InterfaceDemo {

    String name="InterfaceDemo";

    void cry(String name);
    void eat();

    Logger logger = LoggerFactory.getLogger(InterfaceDemo.class.getName());

    /**
     * @Description: 默认方法
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/9 11:42
     *
     */
    default void defaultMethod() {
        logger.info("InterfaceDemo-defaultMethod");
    }

    /**
     * @Description: 静态方法
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/9 11:42
     *
     */
    static void staticMehtod() {
        logger.info("InterfaceDemo-staticMethod");
    }
}
