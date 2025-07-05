package Structural.AdapterDesign.Java;

import java.util.Arrays;
import java.util.List;

// new requirement to fetch as list
interface UserRepository {
    List<User> fetchAllUsers();
}

// my old service returns as array
class LegacyUserService {
    public User[] getAllUsersAsArray() {
        return new User[] {
            new User("John", 22),
            new User("Max", 21)
        };
    }
} 

class User {
    
     String name;
     int age;
    
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + "]";
    }   
}

//  adapter takes old class output and return new logic output
class LegacyUserAdapter implements UserRepository {

    LegacyUserService legacyUserService;

    public LegacyUserAdapter(LegacyUserService legacyUserService) {
        this.legacyUserService = legacyUserService;
    }

    @Override
    public List<User> fetchAllUsers() {
        User[] users = legacyUserService.getAllUsersAsArray();
        return Arrays.asList(users);
    }
}


public class Main {
    public static void main(String[] args) {
        LegacyUserService legacyUserService = new LegacyUserService();
        UserRepository repo = new LegacyUserAdapter(legacyUserService);
        List<User> users = repo.fetchAllUsers();
        users.forEach(System.out::println);
    }
}
