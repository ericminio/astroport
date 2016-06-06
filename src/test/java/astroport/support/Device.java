package astroport.support;

import org.openqa.selenium.WebDriver;

import java.awt.Dimension;

public interface Device  {

    Dimension getWindowSize();

    Dimension inputFieldSize();

    WebDriver getFavoriteBrowser();
}
