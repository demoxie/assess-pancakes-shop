package com.saultech.pancakeshop;

import com.saultech.pancakeshop.entity.User;
import com.saultech.pancakeshop.enums.Role;
import com.saultech.pancakeshop.service.ShopKeeperService;
import com.saultech.pancakeshop.service.ShopKeeperServiceImpl;

import java.util.logging.Logger;

public class PancakeShop {
    public static final Logger logger = Logger.getLogger(PancakeShop.class.getName());
    public static void main(String[] args){
        logger.info("Welcome to the Pancake Shop");
        User user1 = new User("John", Role.USER);
        User user2 = new User("Jane", Role.USER);
        User user3 = new User("Jack", Role.USER);
        User shopKeeper = new User("Shop Keeper", Role.SHOP_KEEPER);
        ShopKeeperService shopKeeperService = new ShopKeeperServiceImpl(shopKeeper);
        shopKeeperService.bakePancake();
        shopKeeperService.servePancake(user1, user2, user3);

        Thread bakingThread = new Thread(() -> {
            while (true) {
                shopKeeperService.bakePancake();
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        bakingThread.start();

        Thread eatingThread = new Thread(() -> {
            while (true) {
                shopKeeperService.servePancake(user1, user2, user3);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        eatingThread.start();

        try {
            bakingThread.join();
            eatingThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
