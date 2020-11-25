package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.entities.User;

public interface AccountService {
    User validateEmailAndPassword(String email, String password);
}
