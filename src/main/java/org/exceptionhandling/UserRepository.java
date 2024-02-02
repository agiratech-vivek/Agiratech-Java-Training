package org.exceptionhandling;

import org.exceptionhandling.customexception.UserNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private static UserRepository userRepository;
    private static int counter;
    private static Map<Integer, User> userDatabase;
    private UserRepository() {
        counter = 1;
        userDatabase = new HashMap<>();
    }
    public static UserRepository getInstance(){
        if(userRepository == null){
            return new UserRepository();
        }
        return userRepository;
    }
    public static void addUser(User user){
        userDatabase.put(counter, user);
        counter++;
    }
    public static User getUser(int id) throws UserNotFoundException {
        if(userDatabase.containsKey(id)){
            return userDatabase.get(id);
        }
        throw new UserNotFoundException("User with id " + id + " not found");
    }

    public static List<User> getUserByName(String name) {
        List<User> userList = new ArrayList<>();
        for(int id : userDatabase.keySet()){
            User user = userDatabase.get(id);
            if(user.getName().equals(name)){
                userList.add(user);
            }
        }
        if(userList.isEmpty()){
            throw new RuntimeException("User with name: " + name + " not found");
        }
        return userList;
    }
}
