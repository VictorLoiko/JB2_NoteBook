package com.epam.jb2.notebook.logic;

import com.epam.jb2.notebook.entity.Note;
import com.epam.jb2.notebook.entity.NoteBook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NoteBookService {
    private static NoteBookService noteBookService;

    private NoteBookService() {
    }

    public static NoteBookService getInstance() {
        if (noteBookService == null) {
            noteBookService = new NoteBookService();
        }
        return noteBookService;
    }

    private int getNoteIndex(NoteBook noteBook, Note note) {
        return noteBook.getNotes().indexOf(note);
    }

    public List<Note> getNotesByName(NoteBook noteBook, String name) {
        List<Note> results = new ArrayList();
        noteBook.getNotes().forEach(note -> {
            if (note.getName().contains(name)) {
                results.add(note);
            }
        });
        return results;
    }

    public List<Note> getNotesByContent(NoteBook noteBook, String content) {
        List<Note> results = new ArrayList();
        noteBook.getNotes().forEach(note -> {
            if (note.getContent().contains(content)) {
                results.add(note);
            }
        });
        return results;
    }

    public List<Note> getNotesByDate(NoteBook noteBook, String dateString, String dateFormatString) {
        List<Note> results = new ArrayList();
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        noteBook.getNotes().forEach(note -> {
            if (dateFormat.format(note.getCreationDate()).equals(dateString)) {
                results.add(note);
            }
        });
        return results;
    }

    public void deleteNoteByName(NoteBook noteBook, String name) {
        getNotesByName(noteBook, name).forEach(note -> {
            noteBook.getNotes().remove(note);
        });

    }
}
