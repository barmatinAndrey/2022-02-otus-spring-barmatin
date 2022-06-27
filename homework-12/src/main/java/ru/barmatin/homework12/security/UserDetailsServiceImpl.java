package ru.barmatin.homework12.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.barmatin.homework12.domain.LibraryUser;
import ru.barmatin.homework12.service.user.LibraryUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final LibraryUserService libraryUserService;

    @Autowired
    public UserDetailsServiceImpl(LibraryUserService libraryUserService) {
        this.libraryUserService = libraryUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        LibraryUser libraryUser = libraryUserService.getLibraryUserByUsername(username);
        if (libraryUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(libraryUser.getUsername())
                .password(libraryUser.getPassword())
                .roles(libraryUser.getRole())
                .build();
    }
}
