package com.systechtraining.interfaces.user;

import java.util.UUID;

public class UserControllerImpl implements UserController{
      @Override
    public User createUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
