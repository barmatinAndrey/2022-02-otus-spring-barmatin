package ru.barmatin.homework13.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.barmatin.homework13.domain.LibraryUser;
import ru.barmatin.homework13.repository.LibraryUserRepository;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {
    private final LibraryUserRepository libraryUserRepository;

    @Autowired
    public LibraryUserServiceImpl(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    @Override
    public LibraryUser getLibraryUserByUsername(String username) {
        return libraryUserRepository.findByUsername(username);
    }
}
