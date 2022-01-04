package org.corejavavolume.annotation;

import java.lang.annotation.Annotation;

public class ActionListenerForImpl implements ActionListenerFor{
    @Override
    public String source() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
