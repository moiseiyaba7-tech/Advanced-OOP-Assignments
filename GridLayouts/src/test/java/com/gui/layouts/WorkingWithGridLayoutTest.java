package com.gui.layouts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import javax.swing.*;

public class WorkingWithGridLayoutTest {

    @Test
    public void testLayoutAndColors() {
        WorkingWithGridLayout app = new WorkingWithGridLayout();
        JFrame frame = app.createJFrame();

        assertTrue(frame.getLayout() instanceof GridLayout, "Layout should be GridLayout");

        assertEquals(Color.BLUE, app.createPanelOne().getBackground());
        assertEquals(Color.GREEN, app.createPanelTwo().getBackground());
        assertEquals(Color.WHITE, app.createPanelThree().getBackground());
        
        frame.dispose(); 
    }
}