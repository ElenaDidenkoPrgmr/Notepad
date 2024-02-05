package com.eldidenko.notepad.repository;

import com.eldidenko.notepad.document.Notepad;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INotepadRepository extends MongoRepository<Notepad,String> {

}
