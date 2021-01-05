package grammar;

import cn.hutool.core.convert.Convert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 数据类型转换
 * @Author: Tu-Yi
 * @Created: 2021/01/05 12:07
 */
public class DataTypeConversion {

    Logger logger = LoggerFactory.getLogger(DataTypeConversion.class.getName());

    /**
     * @Description: int最大值
     * int*int超出了int最大值
     * 将money类型改为long，乘法类型会自动提升
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 12:11
     *
     */
    public void convertIntLong(){
        int year = 20;
        int money = 1000000000;
        long total = year * money;
        //total:-1474836480
        logger.info("total:{}",total);
        long total1 = year * (long)money;
        //total1:20000000000
        logger.info("total1:{}",total1);
    }

    /**
     * @Description: 强制转换超出数据类型范围将会溢出
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 12:14
     *
     */
    public void convertMax(){
        int nNum = 128;
        byte yNum = (byte)nNum;
        //yNum:-128
        logger.info("yNum:{}",yNum);
    }

    /**
     * @Description: 浮点数的转换
     * 单精度转双精度需要补位
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 12:15
     *
     */
    public void convertFloat(){
        double dNum = 12.3f;
        double dNum1 = Double.parseDouble(12.3f + "");
        //dNum:12.300000190734863
        logger.info("dNum:{}",dNum);
        //dNum1:12.3
        logger.info("dNum1:{}",dNum1);


        double oNum = 12.3;
        float lNum = (float)oNum;
        //lNum:12.3
        logger.info("lNum:{}",lNum);
    }

    /**
     * @Description: 字符串和其他类型的相互转换
     * @Return: void
     *
     * @Creator: Tu-Yi
     * @Date: 2021/1/5 12:22
     *
     */
    public void convertString(){

        //String转基本类型
        String s = "123";
        logger.info("byte:{}",Byte.parseByte(s));
        logger.info("short:{}",Short.parseShort(s));
        logger.info("int:{}",Integer.parseInt(s));
        logger.info("long:{}",Long.parseLong(s));
        //double:123.0
        logger.info("double:{}",Double.parseDouble(s));
        //float:123.0
        logger.info("float:{}",Float.parseFloat(s));
        //boolean:false
        logger.info("boolean:{}",Boolean.parseBoolean(s));
        //boolean:true
        logger.info("boolean:{}",Boolean.parseBoolean("true"));
        //boolean:false
        logger.info("boolean:{}",Boolean.parseBoolean("false"));
        //boolean:false
        logger.info("boolean:{}",Boolean.parseBoolean("blue"));
        //boolean:false
        logger.info("boolean:{}",Boolean.parseBoolean("null"));
        logger.info("charAt:{}",s.charAt(0));

        //String转包装类型
        logger.info("Integer:{}",Integer.valueOf(s));
        logger.info("Double:{}",Double.valueOf(s));

        //其他类型转String
        String s1 = Integer.toString(123);
        String s2 = String.valueOf(123);
        String s3 = Double.toString(2.3366);
        String s4 = Convert.toStr(2.3366);

        logger.info("s1:{}",s1);
        logger.info("s2:{}",s2);
        //s3:2.3366
        logger.info("s3:{}",s3);
        //s4:2.3366
        logger.info("s4:{}",s4);
    }
}
