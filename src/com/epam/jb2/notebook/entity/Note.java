package com.epam.jb2.notebook.entity;

import java.util.Date;
import java.util.Objects;

public class Note {
    private String name;
    private Date creationDate;
    private String content;

    public Note(String name, Date creationDate, String content) {
        this.name = name;
        this.creationDate = creationDate;
        this.content = content;
    }

    public Note(String name,  String content) {
        this.name = name;
        this.creationDate = new Date();
        this.content = content;
    }

    public Note(String name) {
        this.name = name;
        this.creationDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note: {" + "name='" + name + '\'' + ", creationDate=" + creationDate + ", content='" + content + '\'' + '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return name.equals(note.name) && creationDate.equals(note.creationDate) && Objects.equals(content, note.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate, content);
    }
}
