package grammar;

import junit.framework.TestCase;

public class OperatorTest extends TestCase {

    public void testCareDiv() {
        new Operator().careDiv();
    }

    public void testSelfOperator() {
        new Operator().selfOperator();
    }

    public void testLogicOperator() {
        new Operator().logicOperator();
    }
}