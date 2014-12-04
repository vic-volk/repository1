package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 10.11.14
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
public class CollectionObjectManager<T> {

    ArrayList<Integer> objects;

    long timeBefore, timeAfter;

    private void setTimeBeforeCheck(){
        timeBefore = System.nanoTime();
    }

    private void calcDifference(String name){
        timeAfter = System.nanoTime();
        System.out.println("Time difference :" + (timeAfter - timeBefore) + "  " + name);
    }

    public void generateObjects(int number){

        objects = new ArrayList<Integer>();

        for(int i=0; i<number; i++){

            objects.add(new Integer(new Random().nextInt()));

        }

    }

    public void checkTimeOfSearch(int size){

        generateObjects(size);
        setTimeBeforeCheck();
        objects.contains("aaa");
        calcDifference("Size:" + size);

    }

    public void checkTimeOfSearchWithSort(int size){

        generateObjects(size);
        sort();
        setTimeBeforeCheck();
        Collections.binarySearch(objects, 222222);
        calcDifference("Size:" + size);

    }

    private void sort(){

        Collections.sort(objects);

    }
}
