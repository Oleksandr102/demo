package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "Note")
public class Note {
    @Id
    public String id;

    public Note(String make, Integer memo, Boolean used) {
        this.make = make;
        this.memo = memo;
        this.used = used;
    }

    private String make;
    private Integer memo;
    private boolean used;

    @Override
    public String toString() {
        return String.format(
                "Note[id=%s, make='%s', memo='%s', used='%s']",
                id, make, memo, used);
    }
}
