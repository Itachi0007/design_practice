package org.memento;

import java.util.*;

public class Editor {
    private String content="";
    private Stack<String> pastContent = new Stack<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.pastContent.add(this.getContent());
        this.content = content;
    }

    public void undo() {
        this.content = pastContent.pop();
    }
}
