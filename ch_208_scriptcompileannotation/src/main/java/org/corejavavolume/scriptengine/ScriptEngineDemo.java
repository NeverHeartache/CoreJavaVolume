package org.corejavavolume.scriptengine;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

public class ScriptEngineDemo {
    public static void main(String[] args) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        List<ScriptEngineFactory> scriptEngineList = engineManager.getEngineFactories();
        scriptEngineList.stream().forEach(e -> {
            System.out.printf("脚本引擎：" + e.getEngineName() + ";\t");
            System.out.printf("名称：" + e.getNames());
            System.out.println();
        });
    }
}
/**
 * 脚本引擎：Oracle Nashorn;	名称：[nashorn, Nashorn, js, JS, JavaScript, javascript, ECMAScript, ecmascript]
 */