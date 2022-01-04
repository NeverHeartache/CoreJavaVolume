package org.corejavavolume.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /**
     * 分析obj的内容
     * @param obj 要分析的对象
     * @return 对象的字符串内容
     */
    public String toString(Object obj){
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class clazz = obj.getClass();
        if (clazz == String.class) return (String) obj;
        if (clazz.isArray()) {
            String r = clazz.getComponentType() + "[] {";
            for (int i = 0; i < Array.getLength(obj); i++) {
                if (i>0) r += ",";
                Object val = Array.get(obj, i);
                if (clazz.getComponentType().isPrimitive()) r += val;
                else r += toString(val);
            }
           return r + "}";
        }
        String r = clazz.getName();
        // inspect the fields of this class and all superclasses
        do {
            r += "[";
            Field[] fields = clazz.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);
            for (Field f : fields) {
                if(!(Modifier.isStatic(f.getModifiers()))) {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try{
                        Class t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        else r += toString(val);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            clazz = clazz.getSuperclass();
        } while(clazz != null);
        return r;
    }
}
