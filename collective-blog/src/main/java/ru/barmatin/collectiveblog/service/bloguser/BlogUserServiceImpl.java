package ru.barmatin.collectiveblog.service.bloguser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.collectiveblog.domain.BlogUser;
import ru.barmatin.collectiveblog.repository.BlogUserRepository;

@Service
public class BlogUserServiceImpl implements BlogUserService {
    private final BlogUserRepository blogUserRepository;

    @Autowired
    public BlogUserServiceImpl(BlogUserRepository blogUserRepository) {
        this.blogUserRepository = blogUserRepository;
    }

    @Override
    public BlogUser getBlogUserByUsername(String username) {
        return blogUserRepository.findByUsername(username);
    }
}
