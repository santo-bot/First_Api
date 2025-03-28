package com.testing.TestApp.Repository;

import com.testing.TestApp.entity.entry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntryRepo extends MongoRepository <entry, ObjectId>{
}
