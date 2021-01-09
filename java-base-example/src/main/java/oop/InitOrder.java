package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 代码块 变量初始化 构造函数初始化顺序
 * 执行顺序：静态语句块-->非静态语句块-->构造函数
 * 实例变量的初始化语句经过编译器处理后，都会合并到构造器中去，合并后两种赋值语句的顺序保持他们在源码中的顺序
 * 静态代码块，静态变量，顺序与代码顺序相关
 * @Author: Tu-Yi
 * @Created: 2021/01/07 12:24
 */
public class InitOrder {

    static Logger logger = LoggerFactory.getLogger(InitOrder.class.getName());

    public InitOrder(double price) {
        logger.info("2--构造函数");
        this.price = price;
    }


    double price = 2.0;

    {
        logger.info("1--非静态语句块");
        price = 3.4;
    }

    static double sPrice1 = 2.0;

    static {
        logger.info("3--静态语句块");
        sPrice1 = 3.4;
    }

    static {
        logger.info("4--静态语句块");
        sPrice2 = 3.4;
    }

    static double sPrice2 = 2.0;

    public static void main(String[] args) {
        InitOrder t = new InitOrder(100);
        logger.info("price:{}",t.price);

        logger.info("sPrice1:{}",sPrice1);

        logger.info("sPrice2:{}",sPrice2);
    }

    //3--静态语句块
    //4--静态语句块
    //1--非静态语句块
    //2--构造函数
    //price:100.0
    //sPrice1:3.4
    //sPrice2:2.0
}
