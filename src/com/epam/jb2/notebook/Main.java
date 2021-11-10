package com.epam.jb2.notebook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main (String[] args) {
        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
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
        System.out.println(noteBook.getNotesByName("Note"));

        System.out.println("Поиск ноутов по времени создания с предопределенным форматом:");
        String dateFormatString = "dd/MM/yyyy";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        System.out.println(noteBook.getNotesByDate(dateFormat.format(date),dateFormatString));

        System.out.println("удаление элементов по имени Note1:");
        noteBook.deleteNoteByName("Note1");
        System.out.println(noteBook.getNotes());
    }
}
