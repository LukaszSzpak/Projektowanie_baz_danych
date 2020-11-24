package services;

import entities.User;

import java.util.List;

public interface UserService {
    public User getUserById(String id);
    public User createUser(User user);
    public User updateUser(User user, String id);
    public User deleteUser(String id);
    public List<User> getAllUsers();
}
