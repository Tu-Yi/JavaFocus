package grammar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 递归的效率问题
 * @Author: Tu-Yi
 * @Created: 2021/01/05 13:08
 */
public class RecursiveTail {

    static Logger logger = LoggerFactory.getLogger(RecursiveTail.class.getName());

    static long factorial(int n) {
        if(n==1) {
            return 1;
        }else {
            return n * factorial(n-1);
        }
    }

    static long loop(long a) {
        long result = 1;
        while (a > 1) {
            result *= a * (a - 1);
            a -= 2;
        }
        return result;
    }

    /**
     * @Description: 递归和循环的比较
     * 递归调用会占用大量的系统堆栈，内存耗用多，在递归调用层次多时速度要比循环慢的多，所以在使用递归时要慎重
     * 任何能用递归解决的问题也能使用迭代解决。当递归方法可以更加自然地反映问题，并且易于理解和调试，并且不强调效率问题时，可以采用递归
     * 在要求高性能的情况下尽量避免使用递归，递归调用既花时间又耗内存
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 13:15
     *
     */
    public static void main(String[] args) {
        long d1 = System.currentTimeMillis();
        logger.info("结果:{}",factorial(20));
        long d2 = System.currentTimeMillis();
        //递归耗时:5
        logger.info("递归耗时:{}",d2-d1);

        long d3 = System.currentTimeMillis();
        logger.info("结果:{}",loop(20));
        long d4 = System.currentTimeMillis();
        //循环耗时:0
        logger.info("循环耗时:{}",d4-d3);
    }
}
