package com.eldidenko.notepad.service.impl;

import com.eldidenko.notepad.document.Notepad;
import com.eldidenko.notepad.dto.NotepadDTO;
import com.eldidenko.notepad.mapper.NotepadCreateEditMapper;
import com.eldidenko.notepad.mapper.NotepadReadMapper;
import com.eldidenko.notepad.repository.INotepadRepository;
import com.eldidenko.notepad.service.interfaces.INotepadService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotepadService implements INotepadService {

    private final INotepadRepository notepadRepository;
    private final NotepadReadMapper notepadReadMapper;
    private final NotepadCreateEditMapper notepadCreateEditMapper;

    @Override
    public List<NotepadDTO> findAllNotepad() {
        return notepadRepository.findAll().stream().map(notepadReadMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public NotepadDTO findNotepadById(String id) {
        Notepad notepad=  notepadRepository.findById(id).orElse(null);
        return notepadReadMapper.map(notepad);
    }

    @Override
    public NotepadDTO createNotepad(NotepadDTO notepadDTO) {
        var notepadToInsert = notepadCreateEditMapper.map(notepadDTO);
        var insertedNotepad = notepadRepository.insert(notepadToInsert);
        return notepadReadMapper.map(insertedNotepad);
    }

    @Override
    public NotepadDTO modifyNotepad(NotepadDTO notepadDTO) {
        var notepadToModify = notepadCreateEditMapper.map(notepadDTO);
        var notepadModified= notepadRepository.save(notepadToModify);
        return  notepadReadMapper.map(notepadModified);
    }
}
