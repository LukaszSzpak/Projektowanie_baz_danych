package services;

import com.mongodb.MongoException;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(String id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else
            throw new MongoException("Record not Found");
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user, String id) {
        return null;
    }

    @Override
    public User deleteUser(String id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
