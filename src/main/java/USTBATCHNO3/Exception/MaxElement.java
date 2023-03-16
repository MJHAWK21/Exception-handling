package USTBATCHNO3.Exception;

import java.util.ArrayList;

public class MaxElement {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(5);
        list.add(3);
        list.add(77);
        list.add(22);
        Integer max = list.stream()
                          .max(Integer::compareTo)
                          .get();

        System.out.println("The maximum element is: " + max);
    }
}



