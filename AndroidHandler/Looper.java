package AndroidHandler;
/*
其中looper是维护messageQueue的
looper开启死循环一直不停的取message
取message的相是handler,又是消费者
*/
public class Looper {
    private static final ThreadLocal<Looper> threadLocal = new ThreadLocal<>();
    /**
     * 存储Message的队列，阻塞式，没有消息则一直等待
     */
    final MessageQueue messageQueue;

    private Looper() {
        messageQueue = new MessageQueue();
    }

    /**
     * 为该线程创建Looper，
     * 若该线程已经有Looper了则不需要再次调用prepare
     */
    public static void prepare() {
        if (threadLocal.get() != null) {
            throw new RuntimeException("Only one Looper may be created per thread");
        }
        threadLocal.set(new Looper());//为该线程准备looper;
    }

    public static void loop() {
        Looper looper = myLooper();
        if (looper == null) {
            throw new RuntimeException("No Looper; Looper.prepare() wasn't called on this thread.");
        }
        MessageQueue messageQueue = looper.messageQueue;

        for (; ; ) {
            Message message = messageQueue.next();//从生产线中取数据;
            message.target.handleMessage(message);
        }
    }

    /**
     * 获取当先线程的Looper
     * @return
     */
    public static Looper myLooper() {
        return threadLocal.get();
    }

}
