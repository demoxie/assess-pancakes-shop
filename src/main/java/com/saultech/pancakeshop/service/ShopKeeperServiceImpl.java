package com.saultech.pancakeshop.service;

import com.saultech.pancakeshop.entity.Pancake;
import com.saultech.pancakeshop.entity.User;
import com.saultech.pancakeshop.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ShopKeeperServiceImpl implements ShopKeeperService{
    private final Logger logger = Logger.getLogger(ShopKeeperServiceImpl.class.getName());
    private volatile boolean isRunning = true;
    private final List<Pancake> pancakes;
    private User shopKeeper;

    public ShopKeeperServiceImpl(User shopKeeper) {
        this.pancakes = new ArrayList<>();
        this.shopKeeper = shopKeeper.getRole() == Role.SHOP_KEEPER ? shopKeeper : null;
    }
    public ShopKeeperServiceImpl(List<Pancake> pancakes) {
        this.pancakes = pancakes;
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
    public void servePancake(User user1, User user2, User user3) {
        while (!this.pancakes.isEmpty()) {
            user1.eatPancake(this.pancakes.remove(0).getQuantity());
            user2.eatPancake(this.pancakes.remove(0).getQuantity());
            user3.eatPancake(this.pancakes.remove(0).getQuantity());
        }
    }
}
