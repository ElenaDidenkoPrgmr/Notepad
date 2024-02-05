package com.eldidenko.notepad.mapper;

import org.mapstruct.Mapper;
//MUST BE DELETED

@Mapper(componentModel = "spring")
public interface INotepadMapper {
    /*@Mapping(target = "createdDate", expression  = "java(java.time.LocalDateTime.now())")
    Notepad toNotepad(NotepadDTO notepadDTO);

    NotepadDTO fromNotepad(Notepad notepad);*/
}
