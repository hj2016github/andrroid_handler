package AndroidHandler;
/*message相当于resource*/
public class Message {
    Handler target;
    public Object obj ;
    public int what ;

    @Override
    public String toString() {
        return   "what="+what+" obj="+obj.toString();
    }
}
