package com.example.demo.reporsitory;

import com.example.demo.models.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findByUsed(boolean used);
    List<Note> findByMake(String make);
    List<Note> findByMemoAfter(Integer memo);
}
