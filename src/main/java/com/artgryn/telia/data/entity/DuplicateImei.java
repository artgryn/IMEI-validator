package com.artgryn.telia.data.entity;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Document
@Data
@Builder
public class DuplicateImei {

    private ObjectId id;

    private Set<String> duplicatedImei;

    @CreatedDate
    private Date createdDate;

}
