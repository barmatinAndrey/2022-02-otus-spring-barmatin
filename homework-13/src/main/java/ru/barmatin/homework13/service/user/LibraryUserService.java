package ru.barmatin.homework13.service.user;

import ru.barmatin.homework13.domain.LibraryUser;

public interface LibraryUserService {

    LibraryUser getLibraryUserByUsername(String username);

}
