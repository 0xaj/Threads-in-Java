public class App implements Runnable {

    private  int count =0;
    App() {
        this.count++;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" "+count);
    }

    public static void main(String[] args) {

        ExecutorService executors = Executors.fixedThreadPool(10);
        for(int i=0 ;i<4;i++)
           executors.execute(new App());

        executors.shutDown();

        System.out.println();

    }


}
