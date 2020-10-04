package com.example.demo;

import com.example.demo.models.Note;
import com.example.demo.reporsitory.NoteRepository;
import com.example.demo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Executor {
    private final NoteRepository repository;
    private final NoteService service;
    private final int memoSize = 8;
    private final boolean used = true;
    private final String skip = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

    @Autowired
    public Executor(NoteRepository repository, NoteService service) {
        this.repository = repository;
        this.service = service;
    }

    public void start() {
        repository.deleteAll();
        service.generatedData();

        margin();
        System.out.println("Display all notes:");
        service.printAll();
        margin();
        System.out.println(skip + "Display by make Venom");
        for (Note note : repository.findByMake("Venom")) {
            System.out.println(note);
        }

        System.out.println(skip + "Display used notes");
        for (Note note : repository.findByUsed(used)) {
            System.out.println(note);
        }

        System.out.println(skip + "Display notes with memo greater then 'required':");
        for (Note note : repository.findByMemoAfter(memoSize)) {
            System.out.println(note);
        }
    }

    public void margin() {
        System.out.println();
    }
}
