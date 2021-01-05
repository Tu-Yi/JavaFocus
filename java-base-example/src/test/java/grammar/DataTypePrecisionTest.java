package grammar;

import junit.framework.TestCase;
import org.junit.Test;

public class DataTypePrecisionTest extends TestCase {
    @Test
    public void testFloatPrecision() {
        new DataTypePrecision().floatPrecision();
    }
    @Test
    public void testBigDecimalDouble(){
        new DataTypePrecision().bigDecimalDouble();
    }

    @Test
    public void testBigDecimalDiv(){
        new DataTypePrecision().bigDecimalDiv();
    }

    @Test
    public void testBigDecimalHuTool(){
        new DataTypePrecision().bigDecimalHuTool();
    }
}