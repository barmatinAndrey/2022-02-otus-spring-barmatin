package ru.barmatin.collectiveblog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.barmatin.collectiveblog.domain.BlogUser;
import ru.barmatin.collectiveblog.service.bloguser.BlogUserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final BlogUserService blogUserService;

    @Autowired
    public UserDetailsServiceImpl(BlogUserService blogUserService) {
        this.blogUserService = blogUserService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        BlogUser blogUser = blogUserService.getBlogUserByUsername(username);
        if (blogUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return User.builder()
                .username(blogUser.getUsername())
                .password(blogUser.getPassword())
                .roles(blogUser.getRole())
                .build();
    }
}
