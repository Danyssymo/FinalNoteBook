package edu.examples.java_classes.dao.impl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.entity.Note;


public class FileDataBase {
    private List<Note> notes = new ArrayList<>();
    private File file = new File("myFile.txt");

    synchronized public List<Note> readFromFile() {
        List<Note> notes_ = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"))) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String[] params;
            String line = reader.readLine();

            while (line != null) {

                params = line.split("&");
                Note newNote = new Note();
                newNote.setId(Integer.parseInt(params[0].split("=")[1]));
                newNote.setTitle(params[1].split("=")[1]);
                newNote.setContent(params[2].split("=")[1]);
                String dateInString = (params[3].split("=")[1]);
                try {
                    Date date = formatter.parse(dateInString);
                    newNote.setDate(date);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                notes_.add(newNote);

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        notes = notes_;
        return notes;
    }

    synchronized public void writeToFile(Note n) {
        try (FileWriter fw = new FileWriter("myFile.txt", true)) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            notes.add(n);
            String str = "Id=" + n.getId() + "&Title=" + n.getTitle() + "&Content=" + n.getContent() + "&Date=" + formatter.format(n.getDate());
            fw.write(str);
            fw.append("\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int countOfNotes() throws DaoException {
        return readFromFile().size();
    }

    private int lastId() throws DaoException {
        return countOfNotes();
    }

    public int getId() throws DaoException {
        return lastId() + 1;
    }

    synchronized public void deleteAll() {
        notes.clear();
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("myFile.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        writer.print("");
        writer.close();
    }

    synchronized public void updateFromFile(Note note) {
        try (FileWriter fw = new FileWriter("myFile.txt", true)) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            readFromFile();
            for (Note note1 : notes) {
                if (note1.getId() == note.getId()) {
                    note1.setTitle(note.getTitle());
                    note1.setContent(note.getContent());
                    notes.add(note1.getId(),note1);
                }
                break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
