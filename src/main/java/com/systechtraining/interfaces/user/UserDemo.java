package com.systechtraining.interfaces.user;

public class UserDemo {
    public static void main(String[] args) {
        UserController uc = new UserControllerImpl();
        User user = new User("001","Mackie");
        User createdUser = uc.createUser(user);
        
        System.out.println(createdUser);
    }
}
