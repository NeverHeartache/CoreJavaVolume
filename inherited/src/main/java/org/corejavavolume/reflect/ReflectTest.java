package org.corejavavolume.reflect;

import org.aspectj.asm.IProgramElement;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReflectTest {
    private String className;

    public ReflectTest(){
        this.className = JOptionPane.showInputDialog("Please input class name:");
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public static void printField(Class clazz){

    }

    public static void printMethod(Class clazz){

    }

    public static void printConstructor(Class clazz){
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + " ");

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
