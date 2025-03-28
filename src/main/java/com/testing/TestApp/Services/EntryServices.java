package com.testing.TestApp.Services;

import com.testing.TestApp.Repository.EntryRepo;
import com.testing.TestApp.entity.entry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntryServices {
    @Autowired
    private EntryRepo EntryRepo;




    public void saveEntry(entry entry){
             EntryRepo.save(entry);
                 }

                 public List<entry>getAll(){
        return EntryRepo.findAll();
                 }

                 public Optional<entry> findById(ObjectId id){
        return EntryRepo.findById(id);

                 }
                 public void deleteById(ObjectId id){
                     EntryRepo.deleteById(id);
                 }

}
