package com.eldidenko.notepad.service.interfaces;

import com.eldidenko.notepad.dto.NotepadDTO;

import java.util.List;

public interface INotepadService {
    List<NotepadDTO> findAllNotepad();
    NotepadDTO findNotepadById(String id);
    NotepadDTO createNotepad(NotepadDTO notepadDTO);
    NotepadDTO modifyNotepad(NotepadDTO notepadDTO);
}
