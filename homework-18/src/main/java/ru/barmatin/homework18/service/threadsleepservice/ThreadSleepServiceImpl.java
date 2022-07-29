package ru.barmatin.homework18.service.threadsleepservice;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ThreadSleepServiceImpl implements ThreadSleepService {

    @Override
    public void sleepRandomly(String methodName) {
        Random rand = new Random();
        int randomNum = rand.nextInt(3) + 1;
        System.out.println(methodName+" - "+randomNum);
        if(randomNum == 3) {
            System.out.println(methodName+" - demonstrating Hystrix action");
            try {
                System.out.println(methodName+" - start sleeping...." + System.currentTimeMillis());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(methodName+ " - hystrix thread interrupted...." + System.currentTimeMillis());
            }
        }
    }

}
