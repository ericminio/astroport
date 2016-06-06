package astroport.features;

import astroport.support.With;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static astroport.support.AppDriver.openBrowser;
import static astroport.support.Launcher.startAppServer;
import static astroport.support.Launcher.stopServerAndCloseBrowser;

public class CreateAstroportTest {

    @Before
    public void startServer() throws IOException {
        startAppServer();
    }

    @After
    public void stopServer() {
        stopServerAndCloseBrowser();
    }

    @Test
    public void displaysNameInInputField() {
        openBrowser(With.laptop).goToAstroportCreationForm().typeName("Moon-1").
                andVerifyThatNameFieldContains("Moon-1");
    }
}
