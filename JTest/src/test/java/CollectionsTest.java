import collections.CollectionManager;
import collections.CollectionObjectManager;
import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 22.10.14
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public class CollectionsTest extends TestCase {

    public void ntestCollections(){

        System.out.println("Just Collections");
        System.out.println("");

        CollectionManager collectionManager = new CollectionManager(1);
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(1);
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(16);
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(256);
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(4096);
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(4096*16);
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(4096*256);
        collectionManager.checkTimingsFind();

        System.out.println("END");
        System.out.println("");

    }

    public void ntestSortedCollections(){

        System.out.println("Sorted Collections");
        System.out.println("");

        CollectionManager collectionManager = new CollectionManager(1);
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(1);
        collectionManager.sortCollections();
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(16);
        collectionManager.sortCollections();
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(256);
        collectionManager.sortCollections();
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(4096);
        collectionManager.sortCollections();
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(4096*16);
        collectionManager.sortCollections();
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(4096*256);
        collectionManager.sortCollections();
        collectionManager.checkTimingsFind();

        System.out.println("END");
        System.out.println("");

    }

    public void ntestSorting(){

        System.out.println("SortingTest");
        System.out.println("");

        CollectionManager collectionManager = new CollectionManager(1);
        collectionManager.checkTimingsFind();

        collectionManager = new CollectionManager(16);

        collectionManager.printVector();
        collectionManager.printArrayList();
        collectionManager.printLinkedList();

        collectionManager.sortCollections();
        collectionManager.checkTimingsFind();

        collectionManager.printVector();
        collectionManager.printArrayList();
        collectionManager.printLinkedList();

        System.out.println("END");
        System.out.println("");

    }

    public void ntestTreeSet(){

        System.out.println("Tree Set");
        System.out.println("");

        CollectionManager collectionManager = new CollectionManager(1, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(1, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(16, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(256, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(4096, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(4096*16, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(4096*256, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(4096*4096, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(4096*4096*16, 1);
        collectionManager.checkTimingsFindTreeSet();

        collectionManager = new CollectionManager(4096*4096*256, 1);
        collectionManager.checkTimingsFindTreeSet();

        System.out.println("END");
        System.out.println("");

    }

    public void testObjects(){

        CollectionObjectManager<Object> collectionObjectManager = new CollectionObjectManager<Object>();

        System.out.println("4096");
        System.out.println("");

        collectionObjectManager.checkTimeOfSearch(4096);
        collectionObjectManager.checkTimeOfSearch(4096);
        collectionObjectManager.checkTimeOfSearch(4096);
        collectionObjectManager.checkTimeOfSearch(4096);
        collectionObjectManager.checkTimeOfSearch(4096);
        collectionObjectManager.checkTimeOfSearch(4096);
        collectionObjectManager.checkTimeOfSearch(4096);
        collectionObjectManager.checkTimeOfSearch(4096);
        collectionObjectManager.checkTimeOfSearch(4096);

        System.out.println("4096*4096");
        System.out.println("");

        for(int i = 0; i < 10; i++){
            collectionObjectManager.checkTimeOfSearch(4096 * 4096);
        }

        System.out.println("4096*4096");
        System.out.println("");

        for (int i = 0; i < 10; i++) {
            collectionObjectManager.checkTimeOfSearchWithSort(4096 * 4096);
        }

    }

}
