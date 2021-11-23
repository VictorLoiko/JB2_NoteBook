package com.epam.jb2.notebook.print;

import com.epam.jb2.notebook.entity.Note;
import com.epam.jb2.notebook.entity.NoteBook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NoteBookConsoleView {
    private static final String delimiterHeader = Stream.generate(() -> "\u2550").limit(89).collect(Collectors.joining());
    private static final String delimiterContent = Stream.generate(() -> "\u2500").limit(89).collect(Collectors.joining());

    public static void print (NoteBook noteBook) {
        System.out.println(String.format("%s", delimiterHeader));
        System.out.println(String.format("\u2551%43s\u2502%43s\u2551", center("Owner: " + noteBook.getOwner(),43), center("Name: "+ noteBook.getName(),43)));
        System.out.println(String.format("%s", delimiterHeader));
        System.out.println(String.format("\u2551%10s\u2502%25s\u2502%50s\u2551",
                center("Name",10),
                center("Date",25),
                center("Content",50)
        ));
        System.out.println(String.format("%s", delimiterHeader));
        noteBook.getNotes().forEach(note -> {
            print(note);
            System.out.println(String.format("%s", delimiterContent));

        });

    }

    public static void print (Note note) {
        String dateFormatString = "dd/MM/yyyy'T'HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        System.out.println(String.format("\u2551%10s\u2502%25s\u2502%50s\u2551",
                center(note.getName(),10),
                center(dateFormat.format(note.getCreationDate()),25),
                center(note.getContent(),50)
        ));
    }
    public static void print (Note... notes) {
        System.out.println(String.format("%s", delimiterContent));
        String dateFormatString = "dd/MM/yyyy'T'HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        for (int i = 0; i < notes.length; i++) {
            System.out.println(String.format("\u2551%10s\u2502%25s\u2502%50s\u2551",
                    center(notes[i].getName(),10),
                    center(dateFormat.format(notes[i].getCreationDate()),25),
                    center(notes[i].getContent(),50)
            ));
        }
    }

    private static String center(String s, int size) {
        return center(s, size, ' ');
    }

    private static String center(String s, int size, char pad) {
        if (s == null || size <= s.length())
            return s;

        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < (size - s.length()) / 2; i++) {
            sb.append(pad);
        }
        sb.append(s);
        while (sb.length() < size) {
            sb.append(pad);
        }
        return sb.toString();
    }
}
