package org.java8features.optionalclass;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private static final Map<Long, User> userRepo = new HashMap<>();
    public static User getUser(long id){
        //return Optional.ofNullable(userRepo.get(id));
        return userRepo.get(id);
    }

    public static void addUser(long id, User user){
        userRepo.put(id, user);
    }

    public static Optional<User> getUserByName(String name){
        for(Long id : userRepo.keySet()){
            if(userRepo.get(id).getName().equals(name)){
                return Optional.ofNullable(userRepo.get(id));
            }
        }
        return Optional.empty();
    }
}
