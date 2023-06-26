package com.saultech.pancakeshop.entity;

import com.saultech.pancakeshop.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class User {
    private UUID id = UUID.randomUUID();
    private String name;
    private Role role;

    public User() {
    }

    public User(String name, Role role) {
        this.name = name;
        this.role = role;
    }

    public void  eatPancake() {
        System.out.println("Yum yum yum");
    }

}
