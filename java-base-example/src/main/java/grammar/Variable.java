package grammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 变量的初始化
 * 类的成员变量不用初始化即可直接使用，JVM会自动初始化，原始变量如int char short long byte初始化为0，float double初始化为0.0，boolean初始化为false，对象 初始化为null
 * 局部变量需要初始化才能使用，没有初始化的变量是不安全的，以引用型变量为例，只有显式的给变量初始化了（赋初值为null），那么上次调用的变量就可以更快的被回收
 * 成员变量的值存放于堆中，JVM在分配内存时将整块区域置为零即 完成了初始化，方便快捷。而局部变量运行时被分配于栈中，量大，生命周期短，如果由JVM完成初始化，将是一笔很大的性能开销
 * @Author: Tu-Yi
 * @Created: 2021/01/04 21:25
 */
public class Variable {

    Logger logger = LoggerFactory.getLogger(Variable.class.getName());

    int memberNumber;
    float memberFloat;
    boolean memberBoolean;
    String memberString;

    public void initVariable(){
        int local;
        // logger.info("local:{}",local); //Variable might not have initialized

        ////memberNumber:0
        logger.info("memberNumber:{}",memberNumber);
        //memberFloat:0.0
        logger.info("memberFloat:{}",memberFloat);
        //memberBoolean:false
        logger.info("memberBoolean:{}",memberBoolean);
        //memberString:null
        logger.info("memberString:{}",memberString);
    }
}
