package java8;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by khegde050916 on 1/21/2018.
 */
public class TreeSetExample {
    public static void main(String args[]){
        SortedSet s = Collections.synchronizedSortedSet(new TreeSet<>());
    }
}
