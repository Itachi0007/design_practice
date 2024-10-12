package org.state.correct;

public class Eraser implements Tool {
    private final ToolType toolType = ToolType.ERASER;

    @Override
    public void mouseDown() {
        System.out.println("Eraser is erasing");
    }

    @Override
    public void mouseUp() {
        System.out.println("Eraser has erased");
    }
}
