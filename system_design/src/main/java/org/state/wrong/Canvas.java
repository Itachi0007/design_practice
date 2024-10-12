package org.state.wrong;

public class Canvas {
    private ToolType currTool;

    public void mouseDown(ToolType tool){
        switch (tool) {
            case BRUSH -> {
                System.out.println("Brush is working");
            }
            case ERASER -> {
                System.out.println("Eraser is working");
            }
            case SELECTION -> {
                System.out.println("Selecting an area");
            }
        }
    }
    public void mouseUp(ToolType tool){
        switch (tool) {
            case BRUSH -> {
                System.out.println("Painted with brush");
            }
            case ERASER -> {
                System.out.println("Erased items");
            }
            case SELECTION -> {
                System.out.println("Selected an area");
            }
        }
    }

    public ToolType getTool() {
        return currTool;
    }

    public void setTool(ToolType tool) {
        this.currTool = tool;
    }
}
