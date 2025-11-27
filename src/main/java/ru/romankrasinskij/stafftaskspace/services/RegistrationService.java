package ru.romankrasinskij.stafftaskspace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.romankrasinskij.stafftaskspace.dto.RegistrationDto;
import ru.romankrasinskij.stafftaskspace.models.User;
import ru.romankrasinskij.stafftaskspace.repositories.UserRepository;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public RegistrationService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public User toUser(RegistrationDto registrationDTO) {
        return new User.Builder()
            .lastName(registrationDTO.getLastName())
            .firstName(registrationDTO.getFirstName())
            .patronymic(registrationDTO.getPatronymic())
            .dateOfBirth(registrationDTO.getDateOfBirth())
            .username(registrationDTO.getUsername())
            .passwordHash(encodePassword(registrationDTO))
            .email(registrationDTO.getEmail())
            .phoneNumber(registrationDTO.getPhoneNumber())
            .telegramUsername(registrationDTO.getTelegramUsername())
            .department(registrationDTO.getDepartment())
            .appointment(registrationDTO.getAppointment())
            .build();
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(int id, User user) {
        user.setId(id);
        userRepository.save(user);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    private String encodePassword(RegistrationDto registrationDTO) {
        String rawPassword = registrationDTO.getPassword();
        String passwordHash = encoder.encode(rawPassword);
        boolean assertTrue = encoder.matches(rawPassword, passwordHash);

        if (assertTrue) {
            return passwordHash;
        }

        return null;
    }
}
