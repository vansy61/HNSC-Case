package com.example.hnsc.services.user;

import com.example.hnsc.models.User;
import com.example.hnsc.repositories.user.UserRepo;

public class UserService implements IUserService{
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return new UserRepo().findUserByEmailAndPassword(email, password);
    }

    @Override
    public void addUser(User user) {

    }
}
