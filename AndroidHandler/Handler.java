package AndroidHandler;
/*handler相当于生产者,可以是耗时操作,
  线程可以是耗时操作,把生产出来的产品传给message作为产品,
  其中的sendMessage传给生产线;
*/
public class Handler {
    private MessageQueue messageQueue;
    public Handler() {
        Looper looper = Looper.myLooper();

        if (looper==null) {
            throw new RuntimeException(
                    "Can't create handler inside thread that has not called Looper.prepare()");

        }
        this.messageQueue=looper.messageQueue;

    }

    public void sendMessage(Message msg) {
        //Looper循环中发现message后，调用message.targer就得到了当前handler，
        // 使用taget.handleMessage
        //就把消息转发给了发送message时的handler的handleMessage函数
        msg.target=this;
        messageQueue.enqueueMessage(msg);

    }

    public void handleMessage(Message msg) {//消费者,消费message;
    }
}
