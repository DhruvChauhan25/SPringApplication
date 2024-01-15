package com.mycompany.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String message) {
        super(message);
        Logger logger= LoggerFactory.getLogger(UserRepository.class);
        logger.error("Book not found ");
    }
}
