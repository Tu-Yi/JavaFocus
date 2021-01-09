package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 单例模式
 * @Author: Tu-Yi
 * @Created: 2021/01/07 12:38
 */
public class SingleDemo {

    static Logger logger = LoggerFactory.getLogger(SingleDemo.class.getName());

    public static void main(String[] args) {
        Single1 ssSingle1 = Single1.getInstance();
        Single1 ssSingle2 = Single1.getInstance();
        //ssSingle1==ssSingle2:true
       logger.info("ssSingle1==ssSingle2:{}",ssSingle1==ssSingle2);

        Single2 ssSingle3 = Single2.getIn();
        Single2 ssSingle4 = Single2.getIn();
        //ssSingle3==ssSingle4:true
        logger.info("ssSingle3==ssSingle4:{}",ssSingle3==ssSingle4);
    }

    /**
     * @Description: 饿汉式  类一加载就有对象
     * @Creator: Tu-Yi
     * @Date: 2021/1/7 12:41
     *
     */
    static class Single1{
        static Single1 single1 = new Single1();
        private Single1() {}
        public static Single1 getInstance() {
            return single1;
        }
    }

    /**
     * @Description: 懒汉式 类加载，没有对象 延迟加载
     * @Creator: Tu-Yi
     * @Date: 2021/1/7 12:41
     *
     */
    static class Single2{
        private Single2(){}

        static Single2 s2 = null;

        public static  Single2 getIn(){
            if(s2 == null){
                s2 = new Single2();
            }
            return s2;
        }
    }
}
