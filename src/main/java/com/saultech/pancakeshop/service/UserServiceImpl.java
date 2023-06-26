package com.saultech.pancakeshop.service;

import com.saultech.pancakeshop.entity.User;

public class UserServiceImpl implements UserService, Runnable{
    private int maxNoOfPancakesPerUser;
    private int noOfPancakesEaten;
    private User user1;
    private User user2;
    private User user3;

    public UserServiceImpl() {
    }

    public UserServiceImpl(int maxNoOfPancakesPerUser, int noOfPancakesEaten, User user1, User user2, User user3) {
        this.maxNoOfPancakesPerUser = maxNoOfPancakesPerUser;
        this.noOfPancakesEaten = noOfPancakesEaten;
        this.user1 = user1;
        this.user2 = user2;
        this.user3 = user3;
    }

    @Override
    public void run() {

    }

    @Override
    public void eatPancake(User user1, User user2, User user3) {
        while (this.noOfPancakesEaten < this.maxNoOfPancakesPerUser) {
            user1.eatPancake();
            user2.eatPancake();
            user3.eatPancake();
            this.noOfPancakesEaten++;
        }
    }
}
