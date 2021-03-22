package PhilosopherUsingThreads;

import javax.swing.*;
import java.util.Random;

public class Philosopher implements Runnable{

        private int id;
        private volatile boolean isFull;
        private Chopstick leftChopstick;
        private Chopstick rightChopstick;
        private Random random;
        private int eatingCounter;

        public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
            this.id = id;
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
            this.random = new Random();
        }

        @Override
        public void run() {

            try{
                //id the person is full, we terminate the thread
                while(!isFull){
                    think();

                    if(leftChopstick.pickUp(this, State.LEFT)){
                        //can pick up left chopstick
                        if(rightChopstick.pickUp(this, State.RIGHT)){
                            //can pick up right chopstick
                            eat();//so he/she can eat
                            rightChopstick.putDown(this, State.RIGHT);
                        }
                        leftChopstick.putDown(this, State.LEFT);

                    }

                }


            }catch (Exception e){
                e.printStackTrace();
            }
        }

    public int getEatingCounter() {
        return eatingCounter;
    }

    public void setEatingCounter(int eatingCounter) {
        this.eatingCounter = eatingCounter;
    }

    public void think() throws InterruptedException {
            System.out.println(this+" is thinking... ");
            Thread.sleep(random.nextInt(1000));
        }

        public void eat() throws InterruptedException {
            System.out.println(this+" is eating... ");
            eatingCounter++;
            Thread.sleep(random.nextInt(1000));

        }

        public void setFull(boolean full){
            this.isFull = full;
        }

        public boolean isFull() {
            return isFull;
        }

    @Override
        public String toString(){
            return "Philosopher "+ id;
        }



}
