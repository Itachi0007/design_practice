package org.memento;

public class Driver {
    public static void main(String[] args) {
        var editor = new Editor();
        editor.setContent("active");
        System.out.println(editor.getContent());

        editor.setContent("passive");
        System.out.println(editor.getContent());

        editor.setContent("1");
        System.out.println(editor.getContent());

        editor.setContent("2");
        System.out.println(editor.getContent());

        editor.undo();
        editor.undo();
        System.out.println(editor.getContent());
    }
}
