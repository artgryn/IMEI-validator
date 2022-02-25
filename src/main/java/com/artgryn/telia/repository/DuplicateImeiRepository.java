package com.artgryn.telia.repository;

import com.artgryn.telia.data.entity.DuplicateImei;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DuplicateImeiRepository extends MongoRepository<DuplicateImei, ObjectId> {
}
