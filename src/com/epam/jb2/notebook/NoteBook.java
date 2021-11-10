package com.epam.jb2.notebook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class NoteBook {
    private String owner;
    private String name;
    private List<Note> notes;

    public NoteBook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    private int getNoteIndex(Note note) {
        return notes.indexOf(note);
    }

    public List<Note> getNotesByName(String name) {
        List<Note> results = new ArrayList();
        notes.forEach(note -> {
            if (note.getName().contains(name)){
                results.add(note);
            }
        });
        return results;
    }

    public List<Note> getNotesByContent(String content) {
        List<Note> results = new ArrayList();
        notes.forEach(note -> {
            if (note.getContent().contains(content)){
                results.add(note);
            }
        });
        return results;
    }

    public List<Note> getNotesByDate(String dateString, String dateFormatString) {
        List<Note> results = new ArrayList();
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        notes.forEach(note -> {
            if (dateFormat.format(note.getCreationDate()).equals(dateString)) {
                results.add(note);
            }
        });
        return results;
    }

    public void deleteNoteByName(String name) {
        getNotesByName(name).forEach(note -> {
            notes.remove(note);
        });

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "NoteBook: {" + "owner='" + owner + '\'' + ", name='" + name + '\'' + ", notes=" + notes + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteBook notebook = (NoteBook) o;
        return owner.equals(notebook.owner) && name.equals(notebook.name) && Objects.equals(notes, notebook.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, name, notes);
    }
}
