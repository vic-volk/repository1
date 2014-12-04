import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 14.11.14
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
public class StatementsTest extends TestCase {

    public void testStatements(){

        boolean result = result();
        System.out.println(result);

        if(result)
            System.out.println("result is true");
        else
            System.out.println("result is false");
        System.out.println("End");
    }

    boolean result(){
        int a = 2, b = 3;
        return ((a & b) == 0) ? true: false;
    }

}
