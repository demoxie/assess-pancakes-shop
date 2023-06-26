package com.saultech.pancakeshop.entity;

import com.saultech.pancakeshop.enums.Role;

import java.util.UUID;
import java.util.logging.Logger;

public class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());
    private static final long serialVersionUID = 1L;
    private UUID id = UUID.randomUUID();
    private String name;
    private Role role;
    private int noOfPancakesEaten;
    private int maxNoOfPancakesPerUser;

    public User() {
        this.maxNoOfPancakesPerUser = 3;
    }

    public User(String name, Role role, int noOfPancakesEaten) {
        this.name = name;
        this.role = role;
        this.noOfPancakesEaten = noOfPancakesEaten;
        this.maxNoOfPancakesPerUser = 3;
    }

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
        this.maxNoOfPancakesPerUser = 3;
    }

    public void  eatPancake(int noOfPancakes) {
        if (noOfPancakes > this.maxNoOfPancakesPerUser) {
            logger.info("You can only eat %d pancakes".formatted(this.maxNoOfPancakesPerUser));
            return;
        }
        this.noOfPancakesEaten += noOfPancakes;
        logger.info("%s has eaten %d pancakes".formatted(this.name, noOfPancakes));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getNoOfPancakesEaten() {
        return noOfPancakesEaten;
    }

    public void setNoOfPancakesEaten(int noOfPancakesEaten) {
        this.noOfPancakesEaten = noOfPancakesEaten;
    }

    public int getMaxNoOfPancakesPerUser() {
        return maxNoOfPancakesPerUser;
    }

    public void setMaxNoOfPancakesPerUser(int maxNoOfPancakesPerUser) {
        this.maxNoOfPancakesPerUser = maxNoOfPancakesPerUser;
    }
}
