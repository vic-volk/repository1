import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 01.12.14
 * Time: 12:37
 * To change this template use File | Settings | File Templates.
 */
public class OperandsTest extends TestCase {

    public void testPlusOperands(){

        int i = 0;
        if(i++ == 0) System.out.println("i in clause:" + i);
        System.out.println("i after clause:" + i);

    }

    public void testShiftOperands(){

        int i = 121;

        System.out.println("before shift:" + Integer.toBinaryString(i) + "|" + i);

        i >>>= 1;

        System.out.println("after shift:" + Integer.toBinaryString(i) + "|" + i);

    }

}
