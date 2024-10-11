package org.state.correct;

public class Brush implements Tool {
    private final ToolType toolType = ToolType.BRUSH;

    @Override
    public void mouseDown() {
        System.out.println("Brush is working");
    }

    @Override
    public void mouseUp() {
        System.out.println("Brush has painted");
    }
}
