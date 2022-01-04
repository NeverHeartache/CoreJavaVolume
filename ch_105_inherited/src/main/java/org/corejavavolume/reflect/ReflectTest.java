package org.corejavavolume.reflect;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {
    private String className;

    public ReflectTest(){
        this.className = JOptionPane.showInputDialog("Please input class name:");
    }

    public String getClassName() {
        return className;
    }

    public static void printField(Class clazz){
        Field[] fields = clazz.getFields();
        for (Field f:fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type + " " + name + ";");
        }
    }

    public static void printMethod(Class clazz){
        Method[] methods = clazz.getMethods();
        for (Method m: methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            System.out.print("  ");
            //print modifiers
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");
            Class[] paramTypes = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(",");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printConstructor(Class clazz){
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");
            //print paramteter types
            Class[] paramTypes = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(",");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void ReflectClass(String name){
        try {
            Class clazz = Class.forName(name);
            Class superClazz = clazz.getSuperclass();//父类
            String modifiers = Modifier.toString(clazz.getModifiers());
            if (modifiers.length() > 0 ) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (superClazz != null && superClazz != Object.class)
                System.out.print(" extends " + superClazz.getName());
            System.out.print(System.lineSeparator() + "{" + System.lineSeparator());
            printConstructor(clazz);//
            System.out.println();
            printField(clazz);
            System.out.println();
            printMethod(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        ReflectTest reflectTest = new ReflectTest();
        String className = reflectTest.getClassName();
        ReflectClass(className);
    }

}
