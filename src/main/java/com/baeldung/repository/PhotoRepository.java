package com.baeldung.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.baeldung.entity.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String>{

}
