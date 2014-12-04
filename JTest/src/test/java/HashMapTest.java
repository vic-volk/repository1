import junit.framework.TestCase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 13.11.14
 * Time: 17:50
 * To change this template use File | Settings | File Templates.
 */
public class HashMapTest extends TestCase {

    Map<String, String> map = new HashMap<String, String>();

    public void testHashMap(){

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++){

                int c = i & j;
                System.out.print(c + " | ");

            }
            System.out.println("");

        }

        System.out.println("");

        for(int i = 0; i < 10; i++){

            for(int j = 0; j < 10; j++){

                int c = i & j;
                System.out.print(hash(j + 10*i) + " | ");

            }
            System.out.println("");

        }


    }

    static int hash(int h) {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

}
