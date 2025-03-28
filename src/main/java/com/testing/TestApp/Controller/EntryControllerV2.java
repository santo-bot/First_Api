package com.testing.TestApp.Controller;

import com.testing.TestApp.Services.EntryServices;
import com.testing.TestApp.entity.entry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/test")
public class EntryControllerV2 {
    @Autowired
    private EntryServices EntryServices;

    @GetMapping//
    public List<entry> getAll() {

        return EntryServices.getAll();
    }

    @PostMapping
    public entry createEntry(@RequestBody entry myEntry){
        myEntry.setDate(LocalDateTime.now());
        EntryServices.saveEntry(myEntry);
        return myEntry;

    }

    @GetMapping("id/{myId}")
    public entry getEntryById(@PathVariable ObjectId myId){
       return EntryServices.findById(myId).orElse(null);

    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId){
        EntryServices.deleteById(myId);
        return true;

    }

    @PutMapping("id/{id}")
    public entry updateEntryById(@PathVariable ObjectId id,@RequestBody entry newEntry){
        entry old=EntryServices.findById(id).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")? newEntry.getContent() :old.getContent());

        }

        EntryServices.saveEntry(newEntry);
        return newEntry;
    }



}
