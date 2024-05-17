package com.example.ControlWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContentController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    QuestsRespository questsRespository;
    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = usersRepository.findAllUsers();
        List<Quest> quests  = questsRespository.findAllQuests();
        model.addAttribute("users", users);
        model.addAttribute("quests", quests);
        return "users";
    }
}
