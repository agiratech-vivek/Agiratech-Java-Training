package org.exceptionhandling;

import org.exceptionhandling.customexception.UserNotFoundException;

import java.util.List;

public class ExceptionHandling {
    public static void main(String[] args) {
        UserRepository userRepository = UserRepository.getInstance();
        User vivek = new User("Vivek", "Bangalore", "vivek@gmail.com", "9958100166");
        User nishant = new User("Nishant", "Delhi", "nishant@gmail.com", "1234567890");
        User saurabh = new User("Saurabh", "Mumbai", "saurabh@gmail.com", "9545421565");
        UserRepository.addUser(vivek);
        UserRepository.addUser(nishant);
        UserRepository.addUser(saurabh);
        try {
            User singleUser = UserRepository.getUser(2);
            List<User> userList = UserRepository.getUserByName("Vivek");
            userList.forEach(user -> System.out.println(user.toString()));
            System.out.println(singleUser);
        } catch (UserNotFoundException userNotFoundException) {
            System.out.println(userNotFoundException.getMessage());
        } catch (RuntimeException runtimeException){
            System.out.println(runtimeException.getMessage());
        } finally {
            System.out.println("Thank you for using the program");
        }
    }
}
