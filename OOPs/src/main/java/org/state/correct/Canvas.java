package org.state.correct;

public class Canvas {
    private Tool currTool;

    public void mouseDown() {
        currTool.mouseDown();
    }

    public void mouseUp() {
        currTool.mouseUp();
    }

    public Tool getCurrTool() {
        return currTool;
    }

    public void setCurrTool(Tool currTool) {
        this.currTool = currTool;
    }
}
