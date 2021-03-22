
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool implements ExecutorService {



    static  int size;
    static int limit;
    public static  LinkedBlockingQueue<Runnable> runnableLinkedBlockingQueue;
    Perform perform;
    static boolean doShutDown = false;
    public ThreadPool(int size) {
        this.size = size;
        this.limit = 0;
        this.runnableLinkedBlockingQueue = new LinkedBlockingQueue<>();

        perform = new Perform();
    }
    public  static int getSize() {

        return size;
    }

    @Override
    public void execute(Runnable runnable) {
        if(!this.doShutDown) {
            runnableLinkedBlockingQueue.add(runnable);

            perform.performExecute();
        }

    }

    @Override
    public void shutDown() {

        this.doShutDown = true;



    }
}
