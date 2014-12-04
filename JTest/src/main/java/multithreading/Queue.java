package multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 20.11.14
 * Time: 11:28
 * To change this template use File | Settings | File Templates.
 */
public class Queue {

    List<String> queue;

    public Queue(){
        queue = new ArrayList<String>();
    }

    public void putInQueue(String element){
        queue.add(queue.size(), element);
    }

    public String getFromQueue(){
        return queue.get(0);
    }

}
