package fr.negosud.api.controllers;

import fr.negosud.api.model.Role;
import fr.negosud.api.service.UserService;
import fr.negosud.api.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
//@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> getCustomers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{email}")
    public User getCustomer(@PathVariable("email") final String email) {
        Optional<User> customer = userService.getUserByEmail(email);
        if(customer.isPresent()){
            return customer.get();
        } else {
            return null;
        }
    }


    @GetMapping("/users/{id}")
    public User getCustomer(@PathVariable("id") final Integer id) {
        Optional<User> customer = userService.getUser(id);
        if(customer.isPresent()){
            return customer.get();
        } else {
            return null;
        }
    }

    @PostMapping("/users")
    public User createCustomer(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") final Integer id, @RequestBody User user){
        Optional<User> u = userService.getUser(id);
        if(u.isPresent()){
            User currentUser = u.get();

            String firstName = user.getFirstName();
            if(firstName != null){
                currentUser.setFirstName(firstName);
            }
            String lastName = user.getLastName();
            if(lastName != null) {
                currentUser.setLastName(lastName);
            }
            String email = user.getEmail();
            if(email != null) {
                currentUser.setEmail(email);
            }
            String password = user.getPassword();
            if(password != null) {
                currentUser.setPassword(password);
            }
            Role role = user.getRole();
            if (role != null) {
                currentUser.setRole(role);
            }
            userService.saveUser(currentUser);
            return currentUser;
        } else {
            return null;
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") final Integer id) {
        userService.deleteUser(id);
    }
}
