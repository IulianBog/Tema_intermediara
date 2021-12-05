package com.temaintermediara.main.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.temaintermediara.main.model.Jocuri;



public interface JocuriRepository extends MongoRepository<Jocuri,String>
{
    Jocuri findJocuriById(String JocuriId);

}