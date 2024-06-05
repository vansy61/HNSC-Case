package com.example.hnsc.services.user;
import com.example.hnsc.models.User;


public interface IUserService {
    User getUserByEmailAndPassword(String email, String password);
}
