package com.apostas.application.services;

import com.apostas.application.dto.FoundMoneyDto;
import com.apostas.application.dto.UserDto;
import com.apostas.application.money.MoneyOperation;
import com.apostas.application.representation.UserRepresentation;
import com.apostas.domain.repository.UserRepository;
import com.apostas.domain.user.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class UserService {

    private UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public List<UserRepresentation> getAllUsers() {
        return this.userRepository.all().stream().map(UserRepresentation::new).collect(Collectors.toList());
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

    public UserRepresentation getUserById(Long id) {
        User user = this.userRepository.get(id);
        return new UserRepresentation(user);
    }

    public void addMoneyUser(FoundMoneyDto foundMoneyDto) {
        User user = this.userRepository.get(foundMoneyDto.getId());
        String newMoney = MoneyOperation.addMoney(user.getDinheiroDisponivel(), foundMoneyDto.getMoney());
        user.setDinheiroDisponivel(newMoney);
    }
}
