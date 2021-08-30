package org.corejavavolume.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfArray {

    public static Object badCopyOf(Object[] a, int newLength){
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newArray.length));
        return newArray;
    }

    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }



    public static void main(String[] args) {
        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        //
        String[] b = {"Tom", "Jarray", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        //
        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyOf(b, 10);
    }
}
/*
[1, 2, 3, 0, 0, 0, 0, 0, 0, 0]
[Tom, Jarray, Harry, null, null, null, null, null, null, null]
The following call will generate an exception.
Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
	at org.corejavavolume.reflect.CopyOfArray.main(CopyOfArray.java:38)

 */

