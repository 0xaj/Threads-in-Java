public interface ExecutorService {

        void execute(Runnable runnable);

        void shutDown();
}
