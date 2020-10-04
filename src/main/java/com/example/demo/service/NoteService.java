package com.example.demo.service;

import com.example.demo.models.Note;
import com.example.demo.reporsitory.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {

    private NoteRepository repository;

    @Autowired
    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public void generatedData(){
        repository.save(new Note("Demon", 8, false));
        repository.save(new Note("Ghost", 4, true));
        repository.save(new Note("Venom", 16, true));
        repository.save(new Note("Horse", 128, false));
        repository.save(new Note("Venom", 4, false));
        repository.save(new Note("Shoe", 16, true));
        repository.save(new Note("Venom", 8, true));
        repository.save(new Note("PC", 32, false));
        repository.save(new Note("ROG", 16, true));
    }

    public void printAll(){
        repository.findAll().forEach(System.out::println);
    }

    public List<Note> printByMemoSize(Integer memo){
        return repository.findByMemoAfter(memo);
    }

    public List<Note> printByMake(String make){
        return repository.findAll(Sort.by(make).descending());
    }
}
