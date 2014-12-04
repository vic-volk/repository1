import junit.framework.TestCase;
import structures.ManInTheCircle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 13.11.14
 * Time: 11:45
 * To change this template use File | Settings | File Templates.
 */
public class ManInTheCircleTest extends TestCase {

    List<Integer> testList = new ArrayList<Integer>();

    public void testOperation(){

        int a = 9;
        int b = 3;

        System.out.println(a%=b);

    }

    public void testManInTheCircle(){

        ManInTheCircle manInTheCircle = new ManInTheCircle(2, 5, 20);
        manInTheCircle.determineNumber();

        manInTheCircle = new ManInTheCircle(2, 16, 45);
        manInTheCircle.determineNumber();

        manInTheCircle = new ManInTheCircle(2, 7, 61);
        manInTheCircle.determineNumber();

        manInTheCircle = new ManInTheCircle(2, 5, 23);
        manInTheCircle.determineNumber();

    }



}
