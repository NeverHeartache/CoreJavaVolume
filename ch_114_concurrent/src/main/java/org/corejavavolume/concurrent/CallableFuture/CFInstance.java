package org.corejavavolume.concurrent.CallableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CFInstance {
    private Callable<Integer> callable;
    private Future<Integer> future;
    private Executor executor;

    public CFInstance() {}

    public void init() {
        executor = Executors.newCachedThreadPool();
    }
}
