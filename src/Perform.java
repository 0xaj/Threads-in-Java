public class Perform implements Runnable {

    public void  performExecute(){
        if(ThreadPool.getSize() > ThreadPool.limit){
           ThreadPool.limit++;
           Thread thread = new Thread(new Perform());
           thread.start();
        }


    }

    @Override
    public void run() {
        while(!ThreadPool.runnableLinkedBlockingQueue.isEmpty())
            try {
                ThreadPool.runnableLinkedBlockingQueue.poll().run();
            }
                catch(NullPointerException e){

                }

    }
}
