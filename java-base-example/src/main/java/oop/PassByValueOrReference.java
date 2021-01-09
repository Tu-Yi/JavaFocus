package oop;

import grammar.DataTypeConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 值传递和引用传递
 * @Author: Tu-Yi
 * @Created: 2021/01/07 11:26
 * {@link https://blog.csdn.net/javazejian/article/details/51192130}
 */
public class PassByValueOrReference {

    static Logger logger = LoggerFactory.getLogger(PassByValueOrReference.class.getName());


    public static void updateValue(int value){
        value *= 3;
    }

    public static void main(String[] args) {
        //调用前x的值：10
        int x = 10;
        logger.info("调用前x的值：{}", x);
        updateValue(x);
        //调用后x的值：10
        logger.info("调用后x的值：{}", x);

        User user = new User("ZangSan", 26);
        // 调用前user的值：User{name='zhangsan', age=26}
        logger.info("调用前user的值：{}",user);
        updateUser(user);
        // 调用后user的值：User{name='Listen', age=18}
        logger.info("调用后user的值：{}",user);


    }

    public static void updateUser(User student){
        student.setName("Listen");
        student.setAge(18);
    }


    static class User {
        private String name;
        private int age;
        public User(String name, int age) {
            this.name=name;
            this.age=age;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
