package com.example.back_end.AiProfileApp.service.auth;

import com.example.back_end.AiProfileApp.dto.auth.UserDetailDTO;
import com.example.back_end.AiProfileApp.entity.User;
import com.example.back_end.AiProfileApp.mapper.auth.UserDetailMapper;
import com.example.back_end.AiProfileApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final UserDetailMapper userDetailMapper;

    @Override
    public UserDetails loadUserByUsername(String nameOrEmail) throws UsernameNotFoundException {
        User user;
        boolean isEmail = nameOrEmail.contains("@");

        if (isEmail) {
            user = userRepository.findByEmail(nameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Datos Invalidos"));
        } else {
            user = userRepository.findByName(nameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Datos Invalidos"));
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getName().toString());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                Collections.singleton(authority));
    }

    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Datos Invalidos"));
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getName().toString());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                Collections.singleton(authority));
    }

    @Override
    public User findByNameOrEmail(String nameOrEmail) {
        boolean isEmail = nameOrEmail.contains("@");

        if (isEmail) {
            return userRepository.findByEmail(nameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Datos Invalidos"));
        } else {
            return userRepository.findByName(nameOrEmail)
                    .orElseThrow(() -> new UsernameNotFoundException("Datos Invalidos"));
        }
    }

    @Override
    public boolean existsByUserName(String name) {
        return userRepository.existsByName(name);
    }

    @Override
    public boolean existsByUserEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deletePendingEmail(String email) {
        userRepository.removeUserByEmail(email);
    }

    public User getUserDetails() {
        String nameOrEmail = SecurityContextHolder.getContext().getAuthentication().getName();

        return findByNameOrEmail(nameOrEmail);
    }

    @Override
    public UserDetailDTO getUserDetailsDTO() {
        User user = getUserDetails();
        return userDetailMapper.toDto(user);
    }

    public void deteleUser(User masterUser) {
        userRepository.deleteById(masterUser.getId());
    }
}
