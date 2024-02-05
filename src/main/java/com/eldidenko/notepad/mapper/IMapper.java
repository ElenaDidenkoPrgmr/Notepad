package com.eldidenko.notepad.mapper;

public interface IMapper<F, T> {

    T map(F object);

    default T map(F fromObject, T toObject) {
        return toObject;
    }
}
