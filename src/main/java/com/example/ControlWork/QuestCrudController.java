package com.example.ControlWork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestCrudController {
    @Autowired
    QuestsRespository questsRespository;
    @PostMapping("/questadd")
    public void addUser(@RequestBody Quest quest) {
        questsRespository.addQuest(quest);
    }

    @DeleteMapping("/questdelete/{id}")
    public ResponseEntity<Void> deleteQuest(@PathVariable Integer id) {
        questsRespository.deleteQuestById(id);
        return ResponseEntity.noContent().build();
    }
}
