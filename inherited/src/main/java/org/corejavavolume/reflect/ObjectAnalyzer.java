package org.corejavavolume.reflect;

import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    public String toString(Object obj){
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";

        return null;
    }
}
