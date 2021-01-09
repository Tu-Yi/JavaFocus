package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 构造函数的执行顺序
 * @Author: Tu-Yi
 * @Created: 2021/01/07 12:06
 */
public class ConstructorOrder {

    static Logger logger = LoggerFactory.getLogger(ConstructorOrder.class.getName());

    private String name;
    private final int age;

    public ConstructorOrder() {
        this.name = "Tu-Yi";
        this.age = 35;
       logger.info("我是无参构造函数 name:{},age:{}",this.name,this.age);
    }
    public ConstructorOrder(String name) {
        this();
        this.name = name;
        logger.info("我是name构造函数 name:{},age:{}",this.name,this.age);
    }
    public ConstructorOrder(String name,int age) {
        this.name = name;
        this.age = age;
        logger.info("我是全参构造函数 name:{},age:{}",this.name,this.age);
    }
    public void speak() {
        logger.info("当前对象 name:{},age:{}",this.name,this.age);
    }
    public static void main(String[] args) {
        ConstructorOrder tt1 = new ConstructorOrder("旺财");
        //  我是无参构造函数 name:Tu-Yi,age:35
        //	我是name构造函数 旺财 35
        //	当前对象：TestThis@15db9742 name:旺财 age:35
        tt1.speak();
        ConstructorOrder tt2 = new ConstructorOrder("小强",1200);
        //	我是全参构造函数 小强 1200
        //	当前对象：TestThis@6d06d69c name:小强 age:1200
        tt2.speak();
    }
}
