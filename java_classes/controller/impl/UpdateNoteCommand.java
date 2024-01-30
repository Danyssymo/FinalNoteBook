package edu.examples.java_classes.controller.impl;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NotebookLogic;

public class UpdateNoteCommand implements Command {
    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {
        String response = null;
        String[] params;
        Note newNote;

        params = request.split("\n");
        newNote = new Note();

        newNote.setId(Integer.parseInt(params[1].split("=")[1]));
        newNote.setTitle(params[2].split("=")[1]);
        newNote.setContent(params[3].split("=")[1]);


        try {

            logic.update(newNote);
            response = "The record was updated successfully.";
        } catch (LogicException e) {
            // log
            response = "The recording is not updated.";
        }

        return response;
    }
}
