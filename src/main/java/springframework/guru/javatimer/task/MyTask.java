package springframework.guru.javatimer.task;

import java.util.Date;
import java.util.TimerTask;

public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Start of mytask at " + new Date());
        timeConsumingTask();
        System.out.println("End of mytask at " + new Date());
        //cancel();
    }
     public void timeConsumingTask() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
     }
}
