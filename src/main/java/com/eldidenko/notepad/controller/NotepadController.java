package com.eldidenko.notepad.controller;

import com.eldidenko.notepad.dto.NotepadDTO;
import com.eldidenko.notepad.service.interfaces.INotepadService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class NotepadController {

    private final INotepadService notepadService;

    @GetMapping("/notepad/all")
    public List<NotepadDTO> findAllNotepad() {
        return new ArrayList<>(notepadService.findAllNotepad());
    }

    @GetMapping("/notepad/id/{id}")
    public ResponseEntity<NotepadDTO> findNotepadById(@PathVariable String id) {
        var notepadDTO = notepadService.findNotepadById(id);
        if(notepadDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notepadDTO);
    }

    @PostMapping("/notepad")
    public ResponseEntity<NotepadDTO> insertNotepad(@RequestBody NotepadDTO notepadDTO) {
        var insertedNotepad = notepadService.createNotepad(notepadDTO);
        return ResponseEntity.ok(insertedNotepad);
    }

    @PutMapping("/notepad")
    public ResponseEntity<NotepadDTO> modifyNotepad(@RequestBody NotepadDTO notepadDTO) {
        var modifiedNotepad = notepadService.modifyNotepad(notepadDTO);
        return ResponseEntity.ok(modifiedNotepad);
    }
}
