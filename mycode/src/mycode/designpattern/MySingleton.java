package mycode.designpattern;

import java.io.Serializable;

public class MySingleton implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private MySingleton() {
        // private constructor
    }
 
    private static class DemoSingletonHolder {
        public static final MySingleton INSTANCE = new MySingleton();
    }
 
    public static MySingleton getInstance() {
        return DemoSingletonHolder.INSTANCE;
    }
 
    protected Object readResolve() {
        return getInstance();
    }
}