package multithreading;

/**
 * Created with IntelliJ IDEA.
 * User: volkov
 * Date: 02.12.14
 * Time: 16:29
 * To change this template use File | Settings | File Templates.
 */
public class Deadlock {

    static class Friend {

        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s"
                    + "  has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                    + " has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {

        final Friend alphonse =
                new Friend("Alphonse");

        final Friend gaston =
                new Friend("Gaston");

        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();

        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}
