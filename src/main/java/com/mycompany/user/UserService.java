package com.mycompany.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    Logger logger= LoggerFactory.getLogger(UserService.class);
    @Autowired private UserRepository repo;
    public List<User> listAll(){
        logger.debug("Listing up all the record");
        return(List<User>) repo.findAll();
    }


    public void save(User user) {
        logger.debug("Saving all the Record");
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result=repo.findById(id);
        if(result.isPresent()){
            logger.debug("Checking id is present and returning the record ");
            return result.get();
        }
        logger.error("Could not find the book ");
        throw new UserNotFoundException("Could not find any book with id "+ id);
    }
    public void delete(Integer id) throws UserNotFoundException {
        Long count=repo.countById(id);
        if (count==null || count==0){
            logger.error("Checking the book is present or not ");
            throw new UserNotFoundException("Could not find any book with ID" + id);
        }
        logger.info("Book is successfully deleted");
        repo.deleteById(id);
    }
}
