package edu.examples.java_classes.output;

import edu.examples.java_classes.entity.Note;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotebookOutput {

    public void print(String title, List<Note> notes) {
        System.out.println();
        System.out.println(title.toUpperCase());
        System.out.println();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Note n : notes) {
            System.out.println(n.getId() + " - " + n.getTitle() + " - " + n.getContent() + " - " + formatter.format(n.getDate()));
        }

    }

}