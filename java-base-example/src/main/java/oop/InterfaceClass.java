package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 测试接口
 * • Interface的所有方法的访问权限，自动被声明为public。确切的说只能为public，当然你可以显示的声明为protected、private，但是编译会出错！
 * • 接口中可以定义“成员变量”，或者说是不可变的常量，因为接口中的“成员变量”会自动变为public static final。可以通过类命名直接访问：ImplementClass.name
 * • 在jdk1.8中可以用default来修饰实现的非抽象方法，接口对象可以直接调用，也可以声明静态方法，但要注意静态方法只能用类名调用，默认方法只能用实例调用
 * • 实现接口的非抽象类必须要实现该接口的所有方法。抽象类可以不用实现。
 * • 不能使用new操作符实例化一个接口，但可以声明一个接口变量，该变量必须引用一个实现该接口的类的对象。可以使用 instanceof 检查一个对象是否实现了某个特定的接口
 * @Author: Tu-Yi
 * @Created: 2021/01/09 11:47
 */
public class InterfaceClass {

    static Logger logger = LoggerFactory.getLogger(InterfaceClass.class.getName());

    public static void main(String[] args) {

        InterfaceDemo student = new Student();
        //Student-defaultMethod
        student.defaultMethod();
        //InterfaceDemo
        logger.info(InterfaceDemo.name);
        //InterfaceDemo-staticMethod
        InterfaceDemo.staticMehtod();

    }

    static class Student implements InterfaceDemo {

        Logger logger = LoggerFactory.getLogger(Student.class.getName());

        @Override
        public void cry(String name) {
            logger.info("InterfaceClass-cry：{}",name);
        }

        @Override
        public void eat() {
            logger.info("InterfaceClass-eat");
        }

        @Override
        public void defaultMethod() {
            logger.info("Student-defaultMethod");
        }
    }

}

