package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.Controller;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();

        String request;
        String response;

//		request = "ADD\nntitle=Книгаааа\ncontent=Туманность Андромеды";
//		response = controller.doAction(request);
//		System.out.println(response);
//
        request = "ADD\ntitle=Журнал\nсоntent=Туманность2 Андромеды";
        response = controller.doAction(request);
        System.out.println(response);

        request = "ADD\ntitle=Лист\nсоntent=Туманность Андромеды";
        response = controller.doAction(request);
        System.out.println(response);

        request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
        response = controller.doAction(request);
        System.out.println(response);

        request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
        response = controller.doAction(request);
        System.out.println(response);

		request = "UPDATE\nid=1\ntitle=Книга\nсоntent=Туманность Андромеды1";
		response = controller.doAction(request);
		System.out.println(response);

        request = "OUTPUT\n";
        response = controller.doAction(request);
        System.out.println(response);

//        request = "FIND\nКнига";
//        response = controller.doAction(request);
//        System.out.println(response);

//		request = "CLEAN\n";
//		response = controller.doAction(request);
//		System.out.println(response);

//		request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
//		response = controller.doAction(request);
//		System.out.println(response);
//
//		request = "OUTPUT\n";
//		response = controller.doAction(request);
//		System.out.println(response);
    }

}
