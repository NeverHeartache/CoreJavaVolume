import java.util.Collection;
import java.util.concurrent.*;

public class ForNopDemo {
    public static void main(String[] args) {
        int s = 1000;
        for (; ; ) {
            System.out.println("这是一个死循环么？");
        }
    }

    /**
     * 添加测试代码，使用 ExecutorCompletionService 处理任务组
     * @param e
     * @param solvers
     * @throws InterruptedException
     * @throws ExecutionException
     */
    void solve(Executor e, Collection<Callable<Result>> solvers) throws InterruptedException, ExecutionException {
        CompletionService<Result> ecs = new ExecutorCompletionService<Result>(e);
        for (Callable<Result> s : solvers)
            ecs.submit(s);
        int n = solvers.size();
        for (int i = 0; i < n; ++i) {
            Result r = ecs.take().get();
            if (r != null)
                use(r);
        }
    }

    void use(Result r) {

    }
}

class Result {

}
