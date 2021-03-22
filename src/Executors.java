public class Executors {

    public static ExecutorService fixedThreadPool(int size){
        return new ThreadPool(size);
    }
}
