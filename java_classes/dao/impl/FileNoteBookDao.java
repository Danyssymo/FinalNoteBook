package edu.examples.java_classes.dao.impl;

import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.util.CreateNewDate;

public class FileNoteBookDao implements NoteBookDao {
    FileDataBase myDb = new FileDataBase();

    @Override
    public void save(Note n) throws DaoException {

        int id = myDb.getId();
        n.setId(id);

        if (n.getDate() == null) {
            n.setDate(CreateNewDate.addDate());
        }
        myDb.writeToFile(n);
    }

    @Override
    public List<Note> allNotes() throws DaoException {
        return myDb.readFromFile();
    }

    @Override
    public void deleteAll() throws DaoException {
        myDb.deleteAll();
    }

    @Override
    public void update(Note note) throws DaoException {
        for (Note n : myDb.readFromFile()) {
            if (n.getId() == note.getId()) {
                n.setTitle(note.getTitle());
                n.setContent(note.getContent());
            }
            myDb.updateFromFile(n);
            break;
        }
    }
}
