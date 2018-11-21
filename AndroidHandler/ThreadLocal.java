package AndroidHandler;

import java.util.HashMap;
import java.util.Map;
/*是一个map用于把looper与线程相关联*/
public class ThreadLocal<T> {
    private Map<Thread,T> map;
    public ThreadLocal() {
        map=new HashMap<>();
    }
    public void set(T obj) {
        map.put(Thread.currentThread(),obj);
    }
    public T get() {
        return map.get(Thread.currentThread());
    }

}
