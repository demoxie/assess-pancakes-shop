package com.saultech.pancakeshop;

import com.saultech.pancakeshop.entity.Pancake;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PancakeShop {
    public static final Logger logger = Logger.getLogger(PancakeShop.class.getName());
    public static void main(String[] args){
        logger.log(Level.INFO, "PancakeShop started");
        List<Pancake> pancakes = new ArrayList<>(12);
        DelayUtil d = new DelayUtil();
        logger.info("Baking Pancakes started at: "+ new Date());
        for (int i = 0; i < 100000; i++) {
            var newPancake = new Pancake("Pancake", 1, 1.0);
            pancakes.add(newPancake);
        }
        d.delay(30000);
        logger.log(Level.INFO, "PancakeShop ended");

        logger.log(Level.INFO, "No of pancakes: "+ pancakes.size());

    }

    public static class DelayUtil {
        /**
         * Delays the current thread execution.
         * The thread loses ownership of any monitors.
         * Quits immediately if the thread is interrupted
         *
         * @param durationInMillis the time duration in milliseconds
         */
        public void delay(final long durationInMillis) {
            delay(durationInMillis, TimeUnit.MILLISECONDS);
        }

        /**
         * @param duration the time duration in the given {@code sourceUnit}
         */
        public void delay(final long duration, final TimeUnit unit) {
            long currentTime = System.currentTimeMillis();
            long deadline = currentTime + unit.toMillis(duration);
            ReentrantLock lock = new ReentrantLock();
            Condition waitCondition = lock.newCondition();

            while ((deadline - currentTime) > 0) {
                try {
                    lock.lockInterruptibly();
                    waitCondition.await(deadline - currentTime, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                } finally {
                    lock.unlock();
                }
                currentTime = System.currentTimeMillis();
            }
        }
    }
}
