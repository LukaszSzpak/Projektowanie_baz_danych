package com.library.libraryDB.services;

import com.library.libraryDB.entities.User;

public interface AccountService {
    User validateEmailAndPassword(String email, String password);
}
