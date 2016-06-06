package astroport.layout;

import astroport.support.With;
import astroport.support.pages.CreateAstroportPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static astroport.support.AppDriver.openBrowser;
import static astroport.support.Launcher.startAppServer;
import static astroport.support.Launcher.stopServerAndCloseBrowser;
import static astroport.support.With.iPhone;
import static astroport.support.With.laptop;
import static astroport.support.layout.HasSizeOfMatcher.hasSizeOf;
import static astroport.support.layout.IsAboveElementMatcher.isAbove;
import static astroport.support.layout.IsRightToElementMatcher.isRightTo;
import static org.junit.Assert.assertThat;

public class CreateAstroportPageLayoutTest {

    CreateAstroportPage page;

    @Before
    public void startServer() throws IOException {
        startAppServer();
    }

    @After
    public void stopServer() {
        stopServerAndCloseBrowser();
    }

    @Test
    public void hasTheExpectedLayoutOnLaptop() {
        page = openBrowser(With.laptop).goToAstroportCreationForm();

        assertThat(page.nameField(), hasSizeOf(laptop.inputFieldSize()));
        assertThat(page.nameField(), isRightTo(page.nameLabel()));
    }

    @Test
    public void hasTheExpectedLayoutOnIPhone() {
        page = openBrowser(With.iPhone).goToAstroportCreationForm();

        assertThat(page.nameField(), hasSizeOf(iPhone.inputFieldSize()));
        assertThat(page.nameLabel(), isAbove(page.nameField()));
    }
}
