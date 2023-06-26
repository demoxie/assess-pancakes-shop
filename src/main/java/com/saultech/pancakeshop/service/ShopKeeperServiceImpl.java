package com.saultech.pancakeshop.service;

import com.saultech.pancakeshop.entity.Pancake;
import com.saultech.pancakeshop.entity.User;
import com.saultech.pancakeshop.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ShopKeeperServiceImpl implements ShopKeeperService, Runnable{
    private final Logger logger = Logger.getLogger(ShopKeeperServiceImpl.class.getName());
    private final List<Pancake> pancakes;
    private User shopKeeper;

    public ShopKeeperServiceImpl(User shopKeeper) {
        this.pancakes = new ArrayList<>();
        this.shopKeeper = shopKeeper.getRole() == Role.SHOP_KEEPER ? shopKeeper : null;
    }
    public ShopKeeperServiceImpl(List<Pancake> pancakes) {
        this.pancakes = pancakes;
    }

    public ShopKeeperServiceImpl(List<Pancake> pancakes, User shopKeeper) {
        this.pancakes = pancakes;
        this.shopKeeper = shopKeeper;
    }



    @Override
    public void bakePancake() {
        Pancake pancake = new Pancake(
                "Pancake",
                10,
                10
        );
        this.pancakes.add(pancake);
    }

    @Override
    public void servePancake() {

    }

    @Override
    public void run() {
        logger.info("ShopKeeperService is running");
        this.bakePancake();
        int maxNoOfPancakes = 12;
        while (this.pancakes.size() < maxNoOfPancakes) {
            this.bakePancake();
        }
    }
}
