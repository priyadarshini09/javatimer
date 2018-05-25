package springframework.guru.javatimer.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class MyTaskTest {
    MyTask myTask;
    Timer timer;

    @Before
    public void setUp() {
        myTask = new MyTask();
        timer = new Timer(true);
    }

    @After
    public void tearDown() {
        myTask = null;
        timer = null;
    }

    @Test
    public void schedulingTaskOnce() {
        long delay = 1000L;
        timer.schedule(myTask, delay*10);
        System.out.println("MyTask begins!!" + new Date());
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void schedulingTaskAtRepeatedInterval() {
        long delay = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(myTask, delay, period);
        System.out.println("MyTask begins and repeats at a specific interval!!" + new Date());
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        timer.cancel();
//        System.out.println("Timer cancelled");
    }

    @Test
    public void schedulingTaskDaily() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 7);
        today.set(Calendar.MINUTE, 51);
        today.set(Calendar.SECOND, 0);
        long delay = 1000L;
        long period = 1000L * 60L * 60L * 24L;
        timer.schedule(myTask, today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)); // period: 1 day
        //timer.scheduleAtFixedRate(myTask, delay, period);
        System.out.println("MyTask begins and repeats every day!!" + new Date());
//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void checkCancelOfTimerTask() {
        long delay = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(myTask, delay, period);
        System.out.println("MyTask begins and repeats at a specific interval and then cancels!!" + new Date());
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkCancelOnTimerObject() {
        long delay = 1000L;
        long period = 1000L;
        timer.scheduleAtFixedRate(myTask, delay, period);
        System.out.println("MyTask begins and repeats at a specific interval!!" + new Date());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("Timer cancelled");
    }

}
