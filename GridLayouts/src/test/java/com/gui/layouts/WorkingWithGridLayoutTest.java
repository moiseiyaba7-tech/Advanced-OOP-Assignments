package com.gui.layouts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkingWithGridLayoutTest {
    @Test
    public void testAppInitialization() {
        WorkingWithGridLayout app = new WorkingWithGridLayout();
        assertNotNull(app, "Application should initialize correctly");
    }
}