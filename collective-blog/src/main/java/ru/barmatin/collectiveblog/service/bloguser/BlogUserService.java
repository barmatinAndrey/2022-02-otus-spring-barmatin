package ru.barmatin.collectiveblog.service.bloguser;

import ru.barmatin.collectiveblog.domain.BlogUser;

public interface BlogUserService {

    BlogUser getBlogUserByUsername(String username);

    void saveBlogUser(BlogUser blogUser);

}
