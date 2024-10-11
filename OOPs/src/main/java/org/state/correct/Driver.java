package org.state.correct;

public class Driver {
    public static void main(String[] args) {
        var canvas = new Canvas();
        Tool Brush = new Brush();
        Tool Eraser = new Eraser();

        canvas.setCurrTool(Brush);
        canvas.getCurrTool().mouseDown();
        canvas.getCurrTool().mouseUp();

        canvas.setCurrTool(Eraser);
        canvas.getCurrTool().mouseDown();
        canvas.getCurrTool().mouseUp();
    }
}
