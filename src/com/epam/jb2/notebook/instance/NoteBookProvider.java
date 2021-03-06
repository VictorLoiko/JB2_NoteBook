package com.epam.jb2.notebook.instance;

import com.epam.jb2.notebook.entity.NoteBook;

public class NoteBookProvider {
    private static NoteBookProvider instance;
    public NoteBook noteBook;

    private NoteBookProvider() {
        this.noteBook = new NoteBook();
    }

    public static NoteBookProvider getInstance() {
        if (instance == null) {
            instance = new NoteBookProvider();
        }
        return instance;
    }

    public NoteBook getNoteBook() {
        return this.noteBook;
    }

}
