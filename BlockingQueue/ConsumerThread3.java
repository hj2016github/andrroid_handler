package BlockingQueue;

public class ConsumerThread3 extends Thread {
    private Resource3 resource3;

             public ConsumerThread3(Resource3 resource) {
                 this.resource3 = resource;
             }

             public void run() {
                 while (true) {
                         try {
                                 Thread.sleep((long) (1000 * Math.random()));
                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                         resource3.remove();
                     }
             }
}
