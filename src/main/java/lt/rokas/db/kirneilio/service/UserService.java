package lt.rokas.db.kirneilio.service;

import lt.rokas.db.kirneilio.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

    User updateUser(User user);

    void deleteUserById(Long id);

    User createUser(String firstName, String email, String phone);
}