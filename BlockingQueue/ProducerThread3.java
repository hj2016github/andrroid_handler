package BlockingQueue;

public class ProducerThread3 extends Thread{
    private Resource3 resource3;

    public ProducerThread3(Resource3 resource) {
        this.resource3 = resource;
        //setName("生产者");
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource3.add();
        }
    }

}
