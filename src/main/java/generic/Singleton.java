package generic;

/**
 * @author pbc
 */
public class Singleton<T>{
    //ERROR
    private T singleInstance;
    public T getSingleInstance(){//  ERROR
        if (singleInstance == null) {
//            construct new instanceof T
        }
        return singleInstance;
    }
}
