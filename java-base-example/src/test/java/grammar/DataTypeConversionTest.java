package grammar;

import junit.framework.TestCase;

public class DataTypeConversionTest extends TestCase {

    public void testConvertIntLong() {
        new DataTypeConversion().convertIntLong();
    }

    public void testConvertMax() {
        new DataTypeConversion().convertMax();
    }

    public void testConvertFloat() {
        new DataTypeConversion().convertFloat();
    }

    public void testConvertString() {
        new DataTypeConversion().convertString();
    }
}