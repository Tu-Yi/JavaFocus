package oop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 装箱和拆箱需要注意的点
 * Integer 构造函数
 * private final int value;
 *
 * public Integer(int value) {
 *     this.value = value;
 * }
 *
 * public Integer(String string) throws NumberFormatException {
 *     this(parseInt(string));
 * }
 *
 * 装箱
 * public static Integer valueOf(int i) {
 *      return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
 * }
 * 装箱的过程会创建对应的对象，这个会消耗内存，所以装箱的过程会增加内存的消耗，影响性能
 * private static final Integer[] SMALL_VALUES = new Integer[256];
 * SMALL_VALUES本来已经被创建好，也就是说在i >= 128 || i < -128是会创建不同的对象，在i < 128 && i >= -128会根据i的值返回已经创建好的指定的对象
 *
 * 拆箱
 * public int intValue() {
 *     return value;
 * }
 *
 * double
 * public static Double valueOf(double d) {
 *     return new Double(d);
 * }
 * 对于Integer，在(-128,128]之间只有固定的256个值，所以为了避免多次创建对象，我们事先就创建好一个大小为256的Integer数组SMALL_VALUES，所以如果值在这个范围内，就可以直接返回我们事先创建好的对象就可以了。
 * 但是对于Double类型来说，我们就不能这样做，因为它在这个范围内个数是无限的。
 * 总结一句就是：在某个范围内的整型数值的个数是有限的，而浮点数却不是
 *
 * Boolean
 * 它并没有创建对象，因为在内部已经提前创建好两个对象，因为它只有两种情况，这样也是为了避免重复创建太多的对象
 * public static Boolean valueOf(boolean b) {
 *     return b ? Boolean.TRUE : Boolean.FALSE;
 * }
 *
 *
 * @Author: Tu-Yi
 * @Created: 2021/01/09 12:42
 * {@link https://www.cnblogs.com/wang-yaz/p/8516151.html}
 */
public class BoxingAndUnBoxing {

    static Logger logger = LoggerFactory.getLogger(BoxingAndUnBoxing.class.getName());

    public static void main(String[] args) {

        Integer i1 = 100;

        Integer i2 = 100;

        Integer i3 = 200;

        Integer i4 = 200;

        //1、i1和i2会进行自动装箱，执行了valueOf函数，它们的值在(-128,128]这个范围内，它们会拿到SMALL_VALUES数组里面的同一个对象SMALL_VALUES[228]，它们引用到了同一个Integer对象，所以它们肯定是相等的。
        //2、i3和i4也会进行自动装箱，执行了valueOf函数，它们的值大于128，所以会执行new Integer(200)，也就是说它们会分别创建两个不同的对象，所以它们肯定不等。
        //true
        logger.info("i1 == i2:{}",i1==i2);
        //false
        logger.info("i3 == i4:{}",i3==i4);

        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;

        //false
        logger.info("d1 == d2:{}",d1==d2);
        //false
        logger.info("d3 == d4:{}",d3==d4);


        Boolean b1 = false;
        Boolean b2 = false;
        Boolean b3 = true;
        Boolean b4 = true;

        //true
        logger.info("b1 == b2:{}",b1==b2);
        //true
        logger.info("b3 == b4:{}",b3==b4);


        {
            //num1 == num2进行了拆箱操作
            //当一个基础数据类型与封装类进行==、+、-、*、/运算时，会将封装类进行拆箱，对基础数据类型进行运算。
            Integer num1 = 400;
            int num2 = 400;
            //true
            logger.info("num1 == num2:{}",num1 == num2);
        }
        {
            //public boolean equals(Object o) {
            //    return (o instanceof Integer) && (((Integer) o).value == value);
            //}
            //类型相同 内容相同
            Integer num1 = 400;
            int num2 = 400;
            //true
            logger.info("num1.equals(num2):{}",num1.equals(num2));
        }
        {
            //运算的时候首先对num3进行拆箱（执行num3的longValue得到基础类型为long的值300），
            // 然后对num1和mum2进行拆箱（分别执行了num1和num2的intValue得到基础类型为int的值100和200），然后进行相关的基础运算
            Integer num1 = 100;
            Integer num2 = 200;
            Long num3 = 300L;
            //true
            logger.info("num3 == (num1 + num2):{}",num3 == (num1 + num2));
        }
        {
            //编译没问题，运行会报错
            //integer100为Integer类型的对象，它当然可以指向null。但在第二行时，就会对integer100进行拆箱，也就是对一个null对象执行intValue()方法，当然会抛出空指针异常
            Integer integer100=null;
            int int100=integer100;

        }



    }

}
