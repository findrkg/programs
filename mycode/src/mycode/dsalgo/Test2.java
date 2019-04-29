package mycode.dsalgo;

import java.util.HashMap;

public class Test2 {
	static Integer i1 = 127;
	static Integer i2 = 127;
    public static void main(String[] args) {
//        if (i1 == i2) {
//            System.out.println("Unbelievable");
//        }
        HashMap<String, String> map = new HashMap<>();
        map.put(null, "Raj");
        System.out.println(map.get(null));
    }
}
