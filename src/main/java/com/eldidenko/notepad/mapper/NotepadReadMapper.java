package com.eldidenko.notepad.mapper;

import com.eldidenko.notepad.document.Notepad;
import com.eldidenko.notepad.dto.NotepadDTO;
import org.springframework.stereotype.Component;

@Component

public class NotepadReadMapper implements IMapper<Notepad, NotepadDTO> {
    @Override
    public NotepadDTO map(Notepad object) {
        NotepadDTO notepadDTO = new NotepadDTO();
        notepadDTO.setId(object.getId());
        notepadDTO.setAuthor(object.getAuthor());
        notepadDTO.setColor(object.getColor());
        return notepadDTO;
    }


}
