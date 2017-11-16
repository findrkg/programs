package mycode.designpattern;

import java.io.Serializable;

public class MySingleton implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /**
     * Bill Pugh Singleton Implementation
     * When the singleton class is loaded, SingletonHelper class is not 
     * loaded into memory and only when someone calls the getInstance method, 
     * this class gets loaded and creates the Singleton class instance.
     * @author RajkishorGupta
     *
     */
    private static class SingletonHolder {
        public static final MySingleton INSTANCE = new MySingleton();
    }

    private MySingleton() {
    	if (SingletonHolder.INSTANCE != null) {
            throw new IllegalStateException("Already instantiated");
        }        // private constructor
    }
 
 
    public static MySingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
 
    protected Object readResolve() {
        return getInstance();
    }
    
    protected Object clone() throws CloneNotSupportedException {
    	return getInstance();
    }
    
    public static void main(String[] args) {
    	MySingleton single2 = MySingleton.getInstance();
    	System.out.println(single2.hashCode());
    	MySingleton single = new MySingleton();
    	System.out.println(single.hashCode());

    }
    
}