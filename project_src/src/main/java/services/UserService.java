package services;

import dtos.UserCreateDto;
import dtos.UserUpdateDto;
import entities.User;

public interface UserService {
    public User getUserById(String id);
    public User createUser(UserCreateDto userCreateDto);
    public User updateUser(UserUpdateDto userUpdateDto, String id);
    public User deleteUser(String id);
}
