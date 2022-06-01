package com.apostas.application.services;

import com.apostas.application.dto.UserDto;
import com.apostas.domain.repository.UserRepository;
import com.apostas.domain.user.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class UserService {

    private UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.all();
    }

    public void addUser(User user) {
        this.userRepository.add(user);
    }

    public void updateUser(UserDto userDto) {
        User user = this.userRepository.get(userDto.getId());
        user.updateUser(userDto);
    }

    public void deleteUser(Long id) {
        User user = this.userRepository.get(id);
        this.userRepository.remove(user);
    }
}
