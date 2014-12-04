package multithreading;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 19.11.14
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
public class Performer implements Runnable {

    Queue queue;
    int id;

    public Performer(int id, Queue queue){

        this.id = id;
        this.queue = queue;

    }

    @Override
    public void run() {



    }

    private void readDataFromQueue(){



    }
}
