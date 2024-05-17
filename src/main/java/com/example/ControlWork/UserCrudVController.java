package com.example.ControlWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserCrudVController {

    @Autowired
    UsersRepository usersRepository;
    @PostMapping("/add")
    public void addUser(@RequestBody User user) {
         usersRepository.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        usersRepository.deleteUserById(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
