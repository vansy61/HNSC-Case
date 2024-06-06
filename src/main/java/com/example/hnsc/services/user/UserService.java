package com.example.hnsc.services.user;

import com.example.hnsc.models.User;
import com.example.hnsc.repositories.user.UserRepo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserService implements IUserService{
    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return new UserRepo().findUserByEmailAndPassword(email, password);
    }

    @Override
    public void addUser(User user) {

    }
}
