package org.corejavavolume.annotation;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ActionListenerInstaller {

    public static void processAnnotations(Object obj) {
        try {
            Class cla = obj.getClass();
            for (Method m : cla.getDeclaredMethods()) {
                ActionListenerFor a = m.getAnnotation(ActionListenerFor.class);
                if (a != null) {
                    Field f = cla.getDeclaredField(a.source());
                    f.setAccessible(true);
                    addListener(f.get(obj), obj, m);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addListener(Object source, final Object param, final Method m)
            throws ReflectiveOperationException {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                m.setAccessible(true);//示例中没有这句代码
                return m.invoke(param);
            }
        };
        Object listener = Proxy.newProxyInstance(null, new Class[]{
                java.awt.event.ActionListener.class
        }, handler);
        Method adder = source.getClass().getMethod("addActionListener", ActionListener.class);
        adder.invoke(source, listener);
    }
}
