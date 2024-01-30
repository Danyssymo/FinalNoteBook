package edu.examples.java_classes.logic;

import java.util.List;

import edu.examples.java_classes.entity.Note;

public interface NotebookLogic {

	public void add(Note n) throws LogicException;// update

	public void add(String title, String content) throws LogicException;

	public List<Note> find(String text) throws LogicException;

	//public List<Note> find(Date date) throws LogicException;

	public List<Note> allNotes() throws LogicException;

	public void clean() throws LogicException;

	public void update(Note note) throws LogicException;
}
