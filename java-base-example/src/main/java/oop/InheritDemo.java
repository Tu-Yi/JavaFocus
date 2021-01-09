package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 继承 构造函数执行顺序
 * 初始化父类时，子类的num为0 ，还没有赋值，父类初始化完成后才初始化子类
 * @Author: Tu-Yi
 * @Created: 2021/01/07 13:00
 */
public class InheritDemo {

    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.show();
    }
}
class Fu{
    Logger logger = LoggerFactory.getLogger(Fu.class.getName());
    Fu() {
        show();
    }
    void show() {
        logger.info("fu show....");
    }
}
class Zi extends Fu{
    int num = 8;
    Zi() {
    }
    @Override
    void show() {
        logger.info("zi show....{}",num);
    }
}
// zi show....0
// zi show....8

