package com.example;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(User user) {
        if (userRepository.userExists(user.getEmail())) {
            return "User already exists.";
        }
        userRepository.addUser(user);
        return "User added successfully.";
    }
}

