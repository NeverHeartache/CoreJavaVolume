package org.corejavavolume.reflect;

import org.corejavavolume.reflect.appendant.Employee;

import java.lang.reflect.Field;

public class IndexClass {
    public static void main(String[] args) {
        Employee harry = new Employee("Harry Poter", 35000, 10, 1, 1989);
        Class clazz = harry.getClass();
        try {
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            Object obj = field.get(harry);
            String name = obj.toString();
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
