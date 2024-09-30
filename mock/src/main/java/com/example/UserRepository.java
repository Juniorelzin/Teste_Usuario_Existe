package com.example;

public interface UserRepository {
    void addUser(User user);
    boolean userExists(String email);
}
