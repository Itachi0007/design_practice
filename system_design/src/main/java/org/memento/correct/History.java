package org.memento.correct;

import java.util.Stack;

public class History {
    private Stack<EditorState> stateHistory = new Stack<>();

    public EditorState getStateHistory() {
        return stateHistory.pop();
    }

    public void setStateHistory(EditorState state) {
        this.stateHistory.add(state);
    }
}
