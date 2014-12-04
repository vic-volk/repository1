import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 01.12.14
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
public class HashSetTest extends TestCase {

    Set<String> set = new HashSet<String>();

    public void testSet(){

        set.add("string");
        set.add("string");
        set.add("string");


    }

}
