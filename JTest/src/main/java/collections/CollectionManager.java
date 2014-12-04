package collections;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 22.10.14
 * Time: 17:05
 * To change this template use File | Settings | File Templates.
 */
public class CollectionManager {

    long timeBefore, timeAfter;

    private Vector<String> vector = new Vector<String>();
    private List<String> arrayList = new ArrayList<String>();
    private List<String> linkedList = new LinkedList<String>();
    private TreeSet<Integer> treeSet = new TreeSet<Integer>();
    private HashSet<String> hashSet = new HashSet<String>();

    public CollectionManager(long number) {

        initCollections(number);

    }

    public CollectionManager(long number, int i) {

        initCollections(number);

    }

    public void initCollections(long number){

        long randomLong;
        int randomInt;

        Random random = new Random();

        for(int i = 0; i < number; i++){

            randomLong = random.nextLong();

            hashSet.add(String.valueOf(randomLong));
            arrayList.add(String.valueOf(randomLong));
            vector.add(String.valueOf(randomLong));
            treeSet.add(1);
            linkedList.add(String.valueOf(randomLong));

        }

    }

    public void initCollectionsTreeSet(long number){

        long randomLong;
        Random random = new Random();

        for(int i = 0; i < number; i++){

            randomLong = random.nextLong();
            treeSet.add(random.nextInt());

        }

    }

    public void checkTimingsFindTreeSet(){


        System.out.println("Size: " + hashSet.size());
        setTimeBeforeCheck();
        treeSet.contains(10241024);
        calcDifference("TreeSet");


    }

    public void checkTimingsFind(){


        System.out.println("Size: " + hashSet.size());
        setTimeBeforeCheck();
        hashSet.contains("a");
        calcDifference("hashSet");
        setTimeBeforeCheck();
        vector.contains("a");
        calcDifference("Vector");
        setTimeBeforeCheck();
        arrayList.contains("a");
        calcDifference("ArrayList");
        setTimeBeforeCheck();
        treeSet.contains("a");
        calcDifference("TreeSet");
        setTimeBeforeCheck();
        linkedList.contains("a" );
        calcDifference("LinkedList");


    }

    public void sortCollections(){

        Collections.sort(vector);
        Collections.sort(arrayList);
        Collections.sort(linkedList);

    }

    private void setTimeBeforeCheck(){
        timeBefore = System.nanoTime();
    }

    private void calcDifference(String name){
        timeAfter = System.nanoTime();
        System.out.println("Time difference :" + (timeAfter - timeBefore) + "  " + name);
    }

    public void printVector(){
        System.out.println("Vector: ");
        for (String number: vector){
            System.out.println(number);
        }
        System.out.println("");
    }

    public void printArrayList(){
        System.out.println("Array list: ");
        for (String number: arrayList){
            System.out.println(number);
        }
        System.out.println("");
    }

    public void printLinkedList(){
        System.out.println("Linked list: ");
        for (String number: linkedList){
            System.out.println(number);
        }
        System.out.println("");
    }

}
