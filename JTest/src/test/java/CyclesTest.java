import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 04.12.14
 * Time: 13:14
 * To change this template use File | Settings | File Templates.
 */
public class CyclesTest extends TestCase {

    public void testBreak(){

        for (int i = 0; i < 15; i++){

            System.out.println(i);

            if(i == 7) {System.out.println("Out"); break;}

        }

    }

}
