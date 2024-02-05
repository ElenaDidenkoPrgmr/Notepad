package com.eldidenko.notepad.mapper;

import com.eldidenko.notepad.document.Notepad;
import com.eldidenko.notepad.dto.NotepadDTO;
import com.eldidenko.notepad.repository.INotepadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NotepadCreateEditMapper implements IMapper<NotepadDTO, Notepad> {

    private final INotepadRepository notepadRepository;

    @Override
    public Notepad map(NotepadDTO notepadDTO) {
        Notepad notepad = new Notepad();
        copy(notepadDTO, notepad);
        return notepad;
    }

    @Override
    public Notepad map(NotepadDTO fromObject, Notepad toObject) {
        copy(fromObject, toObject);
        return toObject;
    }

    private void copy(NotepadDTO notepadDTO, Notepad notepad) {
        if (notepadDTO.getId() != null) {
            notepad.setId(notepadDTO.getId());
        }
        if (notepadDTO.getAuthor() != null) {
            notepad.setAuthor(notepadDTO.getAuthor());
        }
        if (notepadDTO.getColor() != null){
            notepad.setColor(notepadDTO.getColor());
        }

        Optional.ofNullable(notepadDTO.getId())
                .map(notepadRepository::findById)
                .ifPresent(n -> notepad.setCreatedDate(n.get().getCreatedDate()));

    }
}
