package com.saultech.pancakeshop.service;

import com.saultech.pancakeshop.entity.User;

public interface ShopKeeperService {
    void bakePancake();
    void servePancake(User user1, User user2, User user3);
}
