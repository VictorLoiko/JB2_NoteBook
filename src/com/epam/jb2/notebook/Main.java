package com.epam.jb2.notebook;

import com.epam.jb2.notebook.entity.Note;
import com.epam.jb2.notebook.entity.NoteBook;
import com.epam.jb2.notebook.instance.NoteBookProvider;
import com.epam.jb2.notebook.logic.NoteBookService;
import com.epam.jb2.notebook.print.NoteBookConsoleView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main (String[] args) {
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        NoteBookService noteBookService = NoteBookService.getInstance();
        noteBook.setName("Dear Diary");
        noteBook.setOwner("Victor");

        Date date = new Date();
        date.setDate(date.getDate()-1);
        noteBook.addNote(new Note("Note1"));
        noteBook.addNote(new Note("Note2",date,"rfhrty"));
        noteBook.addNote(new Note("Nout"));

        System.out.println();
        NoteBookConsoleView.print(noteBook);
        System.out.println();

        System.out.println("Получение всех ноутов:");
        System.out.println(noteBook.getNotes());

        System.out.println("Поиск по имени Note:");
        System.out.println(noteBookService.getNotesByName(noteBook, "Note"));

        System.out.println("Поиск ноутов по времени создания с предопределенным форматом:");
        String dateFormatString = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        System.out.println(noteBookService.getNotesByDate(noteBook, dateFormat.format(date),dateFormatString));

        System.out.println("удаление элементов по имени Note1:");
        noteBookService.deleteNoteByName(noteBook, "Note1");
        System.out.println(noteBook.getNotes());
    }
}
