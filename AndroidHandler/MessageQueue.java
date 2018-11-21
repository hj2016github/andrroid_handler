package AndroidHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/*messageQueue维护message,相当于生产线,有阻塞
在android中是一个自定义的数据结构,需要调C++进行进行队列的阻塞;*/
public class MessageQueue {
    private BlockingQueue<Message> blockingQueue=new LinkedBlockingQueue<>();
    /**
     * 阻塞式，没有消息则一直等待
     * @return
     */
    public Message next() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }

    /**
     * 插入到消息队列尾部
     * @param message
     */
    void enqueueMessage(Message message) {
        try {
            blockingQueue.put(message);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
