package grammar;

import cn.hutool.core.util.NumberUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Description: 浮点数精度问题 BigDecimal的坑
 * @Author: Tu-Yi
 * @Created: 2021/01/05 10:18
 */
public class DataTypePrecision {

    Logger logger = LoggerFactory.getLogger(DataTypePrecision.class.getName());
    
    /**
     * @Description: 浮点数精度问题
     * 计算机本身是二进制的，而浮点数实际上只是个近似值，所以从二进制转化为十进制浮点数时，精度容易丢失，导致精度下降
     * 根本原因是:十进制值通常没有完全相同的二进制表示形式;十进制数的二进制表示形式可能不精确。只能无限接近于那个值
     * 2.2得到的二进制是一个无限循环的排列 00110011001100110011...
     * 能够用二进制表示的十进制数据，如2.25，这个误差就会不存在
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 10:34
     *
     */
    public void floatPrecision(){
        float f = 2.2f;
        double d = (double) f;
        //d:2.200000047683716
        logger.info("d:{}",d);
        f = 2.25f;
        d = (double) f;
        //d:2.25
        logger.info("d:{}",d);
    }

    /**
     * @Description: BigDecimal(double)不推荐使用
     * 1.111111无法准确地表示为 double（或者说对于该情况，不能表示为任何有限长度的二进制小数）。这样，传入到构造方法的值不会正好等于 0.1（虽然表面上等于该值）
     * 推荐使用：BigDecimal.valueOf  |  new BigDecimal(Double.toString);
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 10:46
     *
     */
    public void bigDecimalDouble(){
        BigDecimal intStr = new BigDecimal("22");

        BigDecimal doubleDecimal = new BigDecimal(1.111111);
        BigDecimal doubleDecimalValueOf = BigDecimal.valueOf(1.111111);
        String s = Double.toString(1.111111);
        BigDecimal doubleStr = new BigDecimal(s);

        //intStr:22
        logger.info("intStr:{}",intStr);
        //doubleDecimal:1.1111109999999999597974920106935314834117889404296875
        logger.info("doubleDecimal:{}",doubleDecimal);
        //doubleDecimalValueOf:1.111111
        logger.info("doubleDecimalValueOf:{}",doubleDecimalValueOf);
        //doubleStr:1.111111
        logger.info("doubleStr:{}",doubleStr);

    }

    /**
     * @Description: BigDecimal除法运算的时候，结果不能整除，有余数，这个时候会报java.lang.ArithmeticException
     * 这边我们要避免这个错误产生，在进行除法运算的时候，针对可能出现的小数产生的计算，必须要多传两个参数
     * divide(BigDecimal，保留小数点后几位小数，舍入模式)
     * ROUND_CEILING    //向正无穷方向舍入
     * ROUND_DOWN    //向零方向舍入
     * ROUND_FLOOR    //向负无穷方向舍入
     * ROUND_HALF_DOWN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向下舍入, 例如1.55 保留一位小数结果为1.5
     * ROUND_HALF_EVEN    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，如果保留位数是奇数，使用ROUND_HALF_UP，如果是偶数，使用ROUND_HALF_DOWN
     * ROUND_HALF_UP    //向（距离）最近的一边舍入，除非两边（的距离）是相等,如果是这样，向上舍入, 1.55保留一位小数结果为1.6,也就是我们常说的“四舍五入”
     * ROUND_UNNECESSARY    //计算结果是精确的，不需要舍入模式
     * ROUND_UP    //向远离0的方向舍入
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 10:46
     *
     */
    public void bigDecimalDiv(){
        BigDecimal intStr = BigDecimal.valueOf(10);
        String s = Double.toString(3);
        BigDecimal doubleStr = new BigDecimal(s);

        //ROUND_CEILING:3.34
        logger.info("ROUND_CEILING:{}",intStr.divide(doubleStr, 2, RoundingMode.CEILING));
        //ROUND_DOWN:3.33
        logger.info("ROUND_DOWN:{}",intStr.divide(doubleStr, 2, RoundingMode.DOWN));
        //ROUND_FLOOR:3.33
        logger.info("ROUND_FLOOR:{}",intStr.divide(doubleStr, 2, RoundingMode.FLOOR));
        //ROUND_HALF_DOWN:3.33
        logger.info("ROUND_HALF_DOWN:{}",intStr.divide(doubleStr, 2, RoundingMode.HALF_DOWN));
        //ROUND_HALF_EVEN:3.33
        logger.info("ROUND_HALF_EVEN:{}",intStr.divide(doubleStr, 2, RoundingMode.HALF_EVEN));
        //ROUND_HALF_UP:3.33
        logger.info("ROUND_HALF_UP:{}",intStr.divide(doubleStr, 2, RoundingMode.HALF_UP));
        //ROUND_UP:3.34
        logger.info("ROUND_UP:{}",intStr.divide(doubleStr, 2, RoundingMode.UP));

        //四舎五入:2.34
        BigDecimal bigDecimal = new BigDecimal("2.3366");
        logger.info("四舎五入:{}",bigDecimal.setScale(2,RoundingMode.HALF_UP));
    }

    /**
     * @Description: BigDecimal HuTool
     * HuTool封装了BigDecimal基本的操作，屏蔽了大量坑，可以直接使用
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 10:46
     *
     */
    public void bigDecimalHuTool(){
        long l = NumberUtil.mul("2.3366", String.valueOf(100)).longValue();
        double d = NumberUtil.mul("2.3366", String.valueOf(100)).doubleValue();
        double add = NumberUtil.add(1.2, 1);
        //l:233
        logger.info("l:{}",l);
        //d:233.66
        logger.info("d:{}",d);
        //add:2.2
        logger.info("add:{}",add);
    }
}
