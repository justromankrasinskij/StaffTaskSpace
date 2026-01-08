package ru.romankrasinskij.stafftaskspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.romankrasinskij.stafftaskspace.dto.UserDto;
import ru.romankrasinskij.stafftaskspace.entity.User;
import ru.romankrasinskij.stafftaskspace.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User toUser(UserDto userDto) {
        return new User.Builder()
                .lastName(userDto.getLastName())
                .firstName(userDto.getFirstName())
                .patronymic(userDto.getPatronymic())
                .dateOfBirth(userDto.getDateOfBirth())
                .username(userDto.getUsername())
                .passwordHash(encodePassword(userDto))
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .telegramUsername(userDto.getTelegramUsername())
                .company(userDto.getCompany())
                .department(userDto.getDepartment())
                .appointment(userDto.getAppointment())
                .build();
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(long id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public String encodePassword(UserDto userDto) {
        PasswordEncoder passwordEncoder = new Argon2PasswordEncoder(10, 10, 1, 1024, 3);

        String rawPassword = userDto.getPassword();
        if (rawPassword == null) {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = findByUsername(username);
            String passwordHash = user.getPasswordHash();

            return passwordHash;
        }

        String hashedPassword = passwordEncoder.encode(rawPassword);;

        boolean assertTrue = passwordEncoder.matches(rawPassword, hashedPassword);

        if (assertTrue) {
            return hashedPassword;
        }

        return "Password error!";
    }
}
