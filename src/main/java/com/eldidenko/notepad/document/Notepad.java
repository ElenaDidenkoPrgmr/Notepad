package com.eldidenko.notepad.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Document
@Entity
public class Notepad extends Auditor{
    @Id
    private String id;
    private String author;
    private String color;

}
