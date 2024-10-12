package org.memento.correct;

public class Driver {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();

        editor.setContent("active");
        history.setStateHistory(editor.currState());
        System.out.println(editor.toString());

        editor.setContent("passive");
        history.setStateHistory(editor.currState());
        System.out.println(editor.toString());

        editor.setContent("Ahmer");
        editor.restore(history.getStateHistory());
        editor.restore(history.getStateHistory());
        System.out.println(editor.toString());

    }
}
