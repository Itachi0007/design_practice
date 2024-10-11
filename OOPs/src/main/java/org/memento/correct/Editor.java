package org.memento.correct;

public class Editor {
    private String content;
    private String title;

    public void restore(EditorState lastState) {
        this.content = lastState.getContent();
        this.title = lastState.getTitle();
    }

    public EditorState currState() {
        return new EditorState(title, content);
    }

    public void setContent(String content) {
        this.content=content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "Editor{" +
                "content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
