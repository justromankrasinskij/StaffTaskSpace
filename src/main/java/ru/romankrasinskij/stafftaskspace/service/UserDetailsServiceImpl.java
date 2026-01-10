package ru.romankrasinskij.stafftaskspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.romankrasinskij.stafftaskspace.entity.User;
import ru.romankrasinskij.stafftaskspace.repository.UserRepository;
import ru.romankrasinskij.stafftaskspace.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user.equals(null)) {
            throw new UsernameNotFoundException("No user with that username was found.");
        }

        return new UserDetailsImpl(user);
    }
}
