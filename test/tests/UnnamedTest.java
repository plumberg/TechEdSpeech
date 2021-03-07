package tests;

import com.codename1.testing.AbstractTest;

import com.codename1.ui.Display;

public class UnnamedTest extends AbstractTest {
    public boolean runTest() throws Exception {
        waitForFormTitle("Precalculus");
        clickButtonByLabel("START");
        clickButtonByLabel("START");
        clickButtonByLabel("STOP");
        return true;
    }
}
